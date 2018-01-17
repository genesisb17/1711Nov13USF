import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { CanActivate } from '@angular/router';

import { Account } from './account';
import { BehaviorSubject } from 'rxjs';


@Injectable()
export class UpdateAccountService{

  public updateSubject = new BehaviorSubject<Account>(null);

  constructor(private http: HttpClient) { }

  deposit(account: Account, amount: number){
    let id = account.id;
    console.log("id " + id + " amount " + amount);
    this.http.post<Account>(environment.apiUrl + "/deposit", [id, amount]).subscribe(acc => {
      if (acc){ 
        console.log("account returned in arrow");
        this.updateSubject.next(acc);
      }
      else {
        console.log("null response in arrow");
      }
    });
  }
  withdraw(account: Account, amount: number){
    let id = account.id;
    console.log("id " + id + " amount " + amount);
    this.http.post<Account>(environment.apiUrl + "/withdraw", [id, amount]).subscribe(acc => {
      if (acc){ 
        console.log("account returned in arrow");
        this.updateSubject.next(acc);
      }
      else {
        console.log("null response in arrow");
      }
    });
  }

  update(id: number, firstname: string, lastname: string, email: string, username: string, password: string, ){
    this.http.post<Account>(environment.apiUrl + "/update", [id, firstname, lastname, email, username, password]).subscribe(acc => {
      if (acc){ 
        console.log("account returned in update arrow");
        this.updateSubject.next(acc);
      }
      else {
        console.log("null response in update arrow");
      }
    });
  }

}
