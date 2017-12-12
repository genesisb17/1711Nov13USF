import { Injectable } from '@angular/core';
import { User } from './types/user.type'
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class AccountService {

  private loggedIn: boolean = false;
  private currentUser: User = new User();
  private loginSubscribers: Function[] = [];
  private logoutSubscribers: Function[] = [];

  constructor(private http: HttpClient, private router: Router) {
  }

  login = (username: string, password: string) => {
    this.http.post<User>("http://localhost:9999/ER/login/login", [username, password], { withCredentials: true })
      .subscribe(resp => {
        if (resp.id != 0) {
          this.currentUser = resp;
          this.loggedIn = true;
          this.loginSubscribers.forEach(f => f(this.loggedIn, this.currentUser));
          this.router.navigate(["home"]);
        }
      });
  }

  logout = () => {
    this.http.get("http://localhost:9999/ER/login/logout").subscribe(resp => {
        this.currentUser = new User();
        this.loggedIn = false;
        this.logoutSubscribers.forEach(f => f());
      });
  }

  register = (user: User) => {
    this.http.post("http://localhost:9999/ER/register/new", [user], { withCredentials: true })
      .subscribe(resp => {
      
    })
  }

  subscribeLogin = (callback: Function) => {
    this.loginSubscribers.push(callback);
  }

  subscribeLogout = (callback: Function) => {
    this.logoutSubscribers.push(callback);
  }

  getcurrentUser = () => { return this.currentUser; }

  isLoggedIn = () => { return this.loggedIn; }

}
