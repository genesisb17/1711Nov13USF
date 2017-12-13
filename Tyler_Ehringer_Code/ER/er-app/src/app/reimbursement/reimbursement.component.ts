import { Component, OnInit, Input } from '@angular/core';
import { Reimbursement } from '../types/reimbursement.type';
import { ReimbursementService } from '../reimbursement.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  @Input() reimbursement: Reimbursement;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  detail() {
    this.router.navigate(["detail", this.reimbursement.id])
  }

}
