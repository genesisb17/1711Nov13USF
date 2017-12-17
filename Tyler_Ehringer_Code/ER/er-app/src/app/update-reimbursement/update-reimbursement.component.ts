import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Reimbursement } from '../types/reimbursement.type';
import { AccountService } from '../account.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-update-reimbursement',
  templateUrl: './update-reimbursement.component.html',
  styleUrls: ['./update-reimbursement.component.css']
})
export class UpdateReimbursementComponent implements OnInit {

  @Input()
  reimbursement: Reimbursement;

  constructor(private amodal:NgbActiveModal, private account: AccountService) { }

  ngOnInit() {
    $(".status").click(() => {
      this.reimbursement.status = $(".status:checked").val();
    });
  }

  submit() {
    this.reimbursement.resolverId = this.account.getcurrentUser().id;
    this.amodal.close(this.reimbursement);
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
