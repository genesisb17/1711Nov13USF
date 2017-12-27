import { Injectable } from '@angular/core';

@Injectable()
export class UserService {

  private isUserLoggedIn;
  private user;

  constructor() {
    this.isUserLoggedIn = false;
  }

  setUserLoggedIn() {
    this.isUserLoggedIn = true;
  }

  setUser(u) {
    this.user = u;
  }

  getUser() {
    return this.user;
  }

  setUserLoggedOut() {
    this.isUserLoggedIn = false;
  }

  getUserLoggedIn() {
    return this.isUserLoggedIn;
  }

}
