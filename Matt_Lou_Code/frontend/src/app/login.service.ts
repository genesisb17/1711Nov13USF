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

  // login(username: string, password: string) {
  //   return this.http.post(this.API_URL + "/login", {
  //     username: username,
  //     password: password
  //   })
  //     .subscribe(users => {
  //       let user = users;
  //       if(user && user.token){
  //         localStorage.setItem(currentUser, JSON.stringify(user));
  //       }
  //     });
  // }

  // login(username: string, password: string){
  //   this.http.get<User[]>(this.API_URL).subscribe(users => {
  //     let filteredUsers = users.filter(user => {
  //       return (user.username.toLowerCase() == username.toLowerCase() && 
  //       user.password == password)
        
  //     });
  //     if(filteredUsers.length > 0){
  //       this.CurrentUser = filteredUsers[0];
  //       // you can call sub => sub() whatever you want ex)f => f()
  //       this.subscribers.forEach(sub => sub());
  //     } else{
  //       this.CurrentUser = null;
  //     }
  //   });
  // }

  login(username: string, password: string) {
    this.http.post<User[]>(this.API_URL + "/login", {
      username: username,
      password: password
    })
      .subscribe(users => {
        console.log(users);
        let filteredUsers = users.filter(user => {
          return (user.username.toLowerCase() == username.toLowerCase() &&
          user.password == password)
        });
        if(filteredUsers.length > 0) {
          this.CurrentUser = filteredUsers[0];
          this.subscribers.forEach(sub => sub());
        } else{
          this.CurrentUser = null;
        }
      },
      err => {
        console.log("error");
      }
    );
  }

  subscribeToLogin(f: Function){
    this.subscribers.push(f);
  }

}
