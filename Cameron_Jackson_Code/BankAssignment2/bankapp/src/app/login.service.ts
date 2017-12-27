import { Injectable } from '@angular/core';
import { UserApiService } from './user-api.service';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/share';
import { User } from './user';
import { Observable } from 'rxjs/Observable';
import { AsyncLocalStorage } from 'angular-async-local-storage';

@Injectable()
export class LoginService {

  loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(
    private uas: UserApiService,
    private localStorage: AsyncLocalStorage
  ) { }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable().share();
  }

  login(user: User): Observable<User> {
    return this.uas.getUserByUsernameAndPassword(user)
      .map((user) => {
        localStorage.setItem("currentUser", JSON.stringify(user));
        this.loggedIn.next(true);
        return user;
      });
  }

  register(user: User): Observable<User> {
    return this.uas.updateUser(user).map((u) => {
      localStorage.setItem("currentUser", JSON.stringify(user));
      this.loggedIn.next(true);
      return u;
    });
  }

  update(user: User): Observable<User> {
    return this.uas.updateUser(user);
  }

  logout() {
    localStorage.removeItem("currentUser");
    this.loggedIn.next(false);
  }

}
