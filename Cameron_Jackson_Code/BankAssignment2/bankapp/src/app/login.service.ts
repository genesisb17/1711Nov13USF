import { Injectable } from '@angular/core';
import { UserApiService } from './user-api.service';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/map';
import { User } from './user';

@Injectable()
export class LoginService {

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private uas: UserApiService) { }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  login(user: User) {
    return this.uas.getUserByUsernameAndPassword(user)
      .map((u) => {
        localStorage.setItem("currentUser", JSON.stringify(u));
        this.loggedIn.next(true);
        return u;
      });
  }

  register(user: User) {
    return this.uas.updateUser(user).map((u) => {
      localStorage.setItem("currentUser", JSON.stringify(u));
      this.loggedIn.next(true);
      return u;
    });
  }

  logout() {
    localStorage.removeItem("currentUser");
  }
}
