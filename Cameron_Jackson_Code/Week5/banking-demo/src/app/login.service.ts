import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment.prod';
import { UserApiService } from './user-api.service';

const API_URL: string = environment.apiUrl;

@Injectable()
export class LoginService {
  currentUser: User;
  subscribers: Function[] = [];

  constructor(private uas: UserApiService) { }

  login(username: string, password: string) {

    this.uas.getAllUsers().subscribe(users => {
      let filteredUsers = users.filter(user => {
        if(user.username.toLowerCase() == username.toLowerCase() && user.password==password) return user;
      });
      if (filteredUsers.length == 1) {
        this.currentUser = filteredUsers[0];
        console.log(this.currentUser);
        this.subscribers.forEach(f => f());
      } else 
        this.currentUser = null;
    });
    
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }
}
