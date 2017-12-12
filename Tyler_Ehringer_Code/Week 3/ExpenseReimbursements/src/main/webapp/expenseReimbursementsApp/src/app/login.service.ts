import { Injectable } from '@angular/core';
import { User } from './types/user.type';
import { HttpClient } from '@angular/common/http'



@Injectable()
export class LoginService {

  private loggedIn: boolean;
  private user: User;
  private loginListeners: ((boolean, User) => void)[];
  private logoutListeners: (() => void)[];

  constructor(private http: HttpClient) { }

  login = (username: string, password: string) => {
    this.http.post<User>("http://localhost:9999/ER/login/login", [username, password], { withCredentials: true })
      .subscribe(resp => {
        this.user = resp;
        this.loggedIn = this.user.id == 0 ? false : true;
        this.loginListeners.forEach(f => f(this.loggedIn, this.user));
      });
  }

  logout = () => {
    this.http.post("http://localhost:9999/ER/login/logout", [], { withCredentials: true })
      .subscribe(resp => {
        this.loggedIn = false;
        this.user = new User();
        this.logoutListeners.forEach(f => f());
      });
  }

  subscribeToLogin = (callback: (boolean, User) => void) => {
    this.loginListeners.push(callback);
  }

  subscribeToLogout = (callback: () => void) => {
    this.logoutListeners.push(callback);
  }

  getCurrentUser = () => {
    if (this.loggedIn) return this.user;
    else return new User();
  }

  isLoggedIn = () => {
    return this.loggedIn;
  }


}
