import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Reimbursement } from '../types/reimbursement.type';
import { AccountService } from '../account.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-create-reimbursement',
  templateUrl: './create-reimbursement.component.html',
  styleUrls: ['./create-reimbursement.component.css']
})
export class CreateReimbursementComponent implements OnInit {

  type: number = 1;
  description: string = "";
  amount: number;

  constructor(private account: AccountService, private amodal: NgbActiveModal) { }

  ngOnInit() {
  }

  submit() {
    let r = new Reimbursement();
    r.amount = this.amount;
    r.authorId = this.account.getcurrentUser().id;
    r.status = 1;
    r.type = this.type;
    r.description = this.description;
    this.amodal.close(r);
  }


  
}
