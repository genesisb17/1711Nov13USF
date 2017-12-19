import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment.prod';
import { UserApiService } from './user-api.service';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';



const API_URL: string = environment.apiUrl;

@Injectable()
export class LoginService {
  currentUser: User;
  subscribers: Function[] = [];

  constructor(private uas: UserApiService) { }

  login(username: string, password: string) {

    return this.uas.getAllUsers().map(users => {
      let filteredUsers = users.filter(user => {
        if(user.username.toLowerCase() == username.toLowerCase() && user.password==password) return user;
      });
      if (filteredUsers.length > 0) {
        // this.currentUser = filteredUsers[0]; 
        localStorage.setItem('currentUser', JSON.stringify(filteredUsers[0]));
      } 
      // else {
      //   // this.currentUser = null;
      //   localStorage.setItem('currentUser', null);
      // }
      return filteredUsers[0];
    });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }
}
