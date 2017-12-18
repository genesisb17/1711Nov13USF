import { Injectable } from '@angular/core';
import { User } from './user';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class LoginService {

  API_URL: string = environment.apiUrl;
  currentUser: User;

  subscribers: Function[] = [];
  
  constructor(private http: HttpClient) { }

  login(username: string, password: string){
    this.http.get<User[]>(this.API_URL + "/users").subscribe(users => {
      let filteredUsers = users.filter(user => {
        if (user.name.toLowerCase() == username.toLowerCase() && user.password == password)
          return user;
      });
      if(filteredUsers.length > 0) {
        this.currentUser = filteredUsers[0];
        this.subscribers.forEach(f => f());
      }
      else {
        this.currentUser = null;
      }
    });
  }

  subcribeToLogin(f: Function){
    this.subscribers.push(f);
  }

}
