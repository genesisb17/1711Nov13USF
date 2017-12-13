import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccountService } from './account.service';
import { User } from './types/user.type';
import { Reimbursement } from './types/reimbursement.type';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ReimbursementService {

  constructor(private http: HttpClient, private account: AccountService) { }

  getReimbursements() {

    if (this.account.getcurrentUser().role == 1) {
      return this.http.get<Reimbursement[]>("http://localhost:9999/ER/reimbursements/user");
    } else {
      return this.http.get<Reimbursement[]>("http://localhost:9999/ER/reimbursements/all");
    }
  }

  addReimbursement(r: Reimbursement) {
    this.http.post<Reimbursement>("http://localhost:9999/ER/reimbursement/add", r, { withCredentials: true }).subscribe(res => {

    });
  }

  updateReimbursement(r: Reimbursement) {
    if (this.account.getcurrentUser().role === 2) {

    }
  }
}
