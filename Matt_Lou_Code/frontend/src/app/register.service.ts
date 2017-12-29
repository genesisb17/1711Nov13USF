import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { User } from './user';

@Injectable()
export class RegisterService {

  API_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }
  // firstname: string, lastname: string, email: string, username: string, 
  // password: string, balance: number
    register(user: User){
      this.http.post(this.API_URL + "/add", {
        firstname: user.firstname,
        lastname: user.lastname, 
        email: user.email,
        username: user.username,
        password: user.password,
        balance: user.balance
      })
        .subscribe(
          data => {
            console.log("register success??");
          }
        )  
    }
}
