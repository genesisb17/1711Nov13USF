import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment.prod';



@Injectable()
export class LoginService {
  API_URL: string = environment.apiUrl;
  currentUser: User;
  subscribers: Function[] = [];

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    console.log("username: " + username + " password: " + password)
    this.http.get<User[]>(this.API_URL).subscribe(users => {
      console.log(users);
      let filteredUsers = users.filter(user => {
        if(user.username.toLowerCase() == username.toLowerCase() && user.password==password) return user;
      });
      if (filteredUsers.length == 1) {
        this.currentUser = filteredUsers[0];
        this.subscribers.forEach(f => f());
      } else 
        this.currentUser = null;
    });
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }
}
