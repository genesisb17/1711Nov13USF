import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { User } from './user';

@Injectable()
export class BalanceService {

  currentUser: User = JSON.parse(localStorage.getItem('user'));
  id: number = this.currentUser.user_id;

  API_URL = environment.apiUrl;
  constructor(private http: HttpClient) { }

  withdraw(balance: number){
    this.http.post(this.API_URL + "/withdraw", {
      user_id: this.id,
      balance: balance
    }) 
      .subscribe(
        res => {
          console.log("withdraw success");
        }
      )
  }
  

  deposit(balance: number) {
    this.http.post(this.API_URL + "/deposit", {
      user_id: this.id,
      balance: balance
    })
      .subscribe(
        res => {
          console.log("deposit success");
        }
      )
  }

}
