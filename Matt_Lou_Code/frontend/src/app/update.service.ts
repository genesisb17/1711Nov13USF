import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http/';
import { environment } from '../environments/environment';
import { User } from './user';

@Injectable()
export class UpdateService {

  API_URL = environment.apiUrl;
  constructor(private http: HttpClient) { }

  currentUser: User = JSON.parse(localStorage.getItem('user'));
  id: number = this.currentUser.user_id;
  
  update(user: User){
    this.http.post(this.API_URL + "/update", {
      user_id: this.id,
      firstname: user.firstname, 
      lastname: user.lastname,
      email: user.email,
      password: user.password
    })
      .subscribe(
        res => {
          console.log(res);
          console.log("updated User");
        }
      )
  }

}
