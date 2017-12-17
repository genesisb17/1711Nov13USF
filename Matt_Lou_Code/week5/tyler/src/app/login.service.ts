import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';


@Injectable()
export class LoginService {

  API_URL = environment.apiUrl;
  CurrentUser: User;

  subscribers: Function[] = [];

  constructor(private http: HttpClient) { }

  login(username: string, password: string){
    this.http.get<User[]>(this.API_URL + "/users").subscribe(users => {
      let filteredUsers = users.filter(user => {
        return (user.name.toLowerCase() == username.toLowerCase() && 
        user.password == password)
        
      });
      if(filteredUsers.length > 0){
        this.CurrentUser = filteredUsers[0];
        // you can call sub => sub() whatever you want ex)f => f()
        this.subscribers.forEach(sub => sub());
      } else{
        this.CurrentUser = null;
      }
    });
  }

  subscribeToLogin(f: Function){
    this.subscribers.push(f);
  }

}
