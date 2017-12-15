import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable()
export class LoginService {

  currentUser: User;
  API_URL = environment.apiUrl + "/users";

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    this.http.get<User[]>(this.API_URL).subscribe(users => {
      let filteredUsers = users.filter(user => {
        (user.name).toLocaleLowerCase() == username.toLocaleLowerCase() && user.password==password;
      })
      if (filteredUsers.length > 0){
        this.currentUser = filteredUsers[0];
      }
      else this.currentUser = null;
    });
  
  }
}
