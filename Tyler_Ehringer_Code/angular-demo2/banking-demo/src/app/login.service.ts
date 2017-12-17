import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { getCurrentDebugContext } from '@angular/core/src/view/services';

@Injectable()
export class LoginService {

  API_URL= environment.apiUrl;
  currentUser: User;

  subscribers: Function[] = [];

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    this.http.get<User[]>(this.API_URL + "/users").subscribe(users => {
      console.log(users);
      let filteredUsers = users.filter(user => {
        if (user.name.toLowerCase() == username.toLowerCase() &&
          user.password == password) return user;
      });
      console.log(filteredUsers);
      if (filteredUsers.length > 0) {
        this.currentUser = filteredUsers[0];
        this.subscribers.forEach(f => f());
      } else {
        this.currentUser = null;
      }
    });
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }

}
