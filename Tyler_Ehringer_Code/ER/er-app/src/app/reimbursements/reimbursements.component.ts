import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { ReimbursementService } from '../reimbursement.service';
import { Reimbursement } from '../types/reimbursement.type';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CreateReimbursementComponent } from '../create-reimbursement/create-reimbursement.component';
import { UpdateReimbursementComponent } from '../update-reimbursement/update-reimbursement.component';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  private page = 0;
  private reimbursements: Reimbursement[] = [];
  private currentPage: Reimbursement[] = [];
  private itemsPerPage = 10;

  private status = {
    pending: true,
    approved: true,
    denied: true
  }


  private sortBy = "submitted";
  private reverseSort = false;

  constructor(private account: AccountService, private reimbs: ReimbursementService, private modal: NgbModal) { }


  ngOnInit() {
    this.getReimbursements();
  }

  getReimbursements() {
    this.filter();
  }

  paginateReimbursements() {
    this.currentPage = this.reimbursements.slice((this.page - 1) * this.itemsPerPage,
      (this.page - 1) * this.itemsPerPage + this.itemsPerPage);
  }

  get currentUser() {
    return this.account.getcurrentUser();
  }

  addReimbursement(r: Reimbursement) {
    this.reimbs.addReimbursement(r).subscribe(resp => {
      this.getReimbursements();
    })
  }

  openNewReimbursement() {
    var newReimb = this.modal.open(CreateReimbursementComponent);
    newReimb.result.then(reimb => {
      this.addReimbursement(reimb);
    }, reason => { });
  }

  changePage(page) {
    this.paginateReimbursements();
  }

  updateReimbursement(r: Reimbursement) {
    var update = this.modal.open(UpdateReimbursementComponent);
    update.componentInstance.reimbursement = r;
    update.result.then(reimb => {
      this.reimbs.updateReimbursement(reimb).subscribe(res => {
        this.getReimbursements();
      })
    }, reason => { });
  }

  filter() {
    this.reimbs.getReimbursements().subscribe(res => {
      res = res.filter(r => {
        if (!this.status.pending && r.status == 1) return false;
        if (!this.status.approved && r.status == 2) return false;
        if (!this.status.denied && r.status == 3) return false;
        return true;
      });
      res.sort((a, b) => {
        if (a[this.sortBy] < b[this.sortBy]) return -1;
        return 1;
      });
      if (this.reverseSort) res = res.reverse();
      this.reimbursements = res;
      this.paginateReimbursements();
    });
  }

  togglePending() {
    this.status.pending = !this.status.pending;
    this.filter();
  }

  toggleApproved() {
    this.status.approved = !this.status.approved;
    this.filter();
  }

  toggleDenied() {
    this.status.denied = !this.status.denied;
    this.filter();
  }

  sort(by: string) {
    this.sortBy = by;
    this.filter();
  }

}
