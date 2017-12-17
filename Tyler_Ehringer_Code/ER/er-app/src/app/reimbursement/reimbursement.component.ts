import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Reimbursement } from '../types/reimbursement.type';
import { ReimbursementService } from '../reimbursement.service';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';



@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  @Output() update: EventEmitter<Reimbursement> = new EventEmitter();
  @Input() reimbursement: Reimbursement;
  submittedDate: string;
  resolvedDate: string;

  constructor(private router: Router, private account: AccountService) { }

  ngOnInit() {
    if (this.reimbursement.submitted) {
      this.submittedDate = new Date(this.reimbursement.submitted).toLocaleString();
    } else {
      this.submittedDate = "";
    }

    if (this.reimbursement.resolved) {
      this.resolvedDate = new Date(this.reimbursement.resolved).toLocaleString();
    } else {
      this.resolvedDate = "Pending";
    }
  }

  get currentUser() {
    return this.account.getcurrentUser();
  }

  updateReimbursement() {
    this.update.emit(this.reimbursement);
  }

  statusString(status: number) {
    if (status == 1) return "Pending";
    if (status == 2) return "Approved";
    else return "Denied";
  }

  typeString(type: number) {
    if (type == 1) return "Lodging";
    if (type == 2) return "Travel";
    if (type == 3) return "Food";
    else return "Other";
  }

  dateTimeToString(dateTime: number) {
    if (dateTime) return new Date(dateTime).toLocaleString();
    return "";
  }

}
