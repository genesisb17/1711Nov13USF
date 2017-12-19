import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { UserService } from './user.service';

@Injectable()
export class LoginService {

  currentUser: User;
  API_URL = environment.apiUrl + "/users";

  subscribers: Function[] = [];


  constructor(private http: HttpClient, private userService: UserService) { }


  validate(username: string, password: string) {

    this.userService.getUsers().subscribe(users => {
      let filteredUsers = users.filter(user => {
        if (user.username.toLowerCase() == username.toLowerCase() && user.password == password) return user;
      })
      if (filteredUsers.length > 0) {
        this.currentUser = filteredUsers[0];
        this.subscribers.forEach(f => f())
      }
      else this.currentUser = null;
    });
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }
}
