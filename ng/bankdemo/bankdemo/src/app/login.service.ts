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


  validate(email: string, password: string) {

    this.userService.getUsers().subscribe(users => {
      let filteredUsers = users.filter(user => {
        if (user.email.toLowerCase() == email.toLowerCase() && user.password == password) return user;
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

  login(email:string, password:string){
    console.log("in login");
    this.userService.getUser(email).subscribe(
      user=>{
        if(user==null) {
          console.log(user);
          return null;
        }
        else{ 
          return user;
        }
      }

    )
  }
}
