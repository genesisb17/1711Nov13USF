import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccountService } from './account.service';
import { User } from './types/user.type';
import { Reimbursement } from './types/reimbursement.type';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class ReimbursementService {

  constructor(private http: HttpClient, private account: AccountService) { }

  getReimbursements() {

    if (this.account.getcurrentUser().role == 1) {
      return this.http.get<Reimbursement[]>("http://localhost:9999/ER/reimbursements/user", {withCredentials: true});
    } else {
      return this.http.get<Reimbursement[]>("http://localhost:9999/ER/reimbursements/all", {withCredentials: true});
    }
  }

  addReimbursement(r: Reimbursement) {
    return this.http.post<Reimbursement>("http://localhost:9999/ER/reimbursements/add", r, { withCredentials: true });
  }

  updateReimbursement(r: Reimbursement) {
    if (this.account.getcurrentUser().role === 2) {
      return this.http.post<Reimbursement>("http://localhost:9999/ER/reimbursements/update", r, { withCredentials: true });
    }
  }
}
