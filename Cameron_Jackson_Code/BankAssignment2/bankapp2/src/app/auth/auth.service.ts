import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { User } from '../beans/user';
import { UserApiService } from './../services/user-api.service';

@Injectable()
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  constructor(
    private router: Router,
    private uas: UserApiService
  ) { }

  login (user: User) {
    this.uas.getUserByUsernameAndPassword(user).subscribe((user) => {
      if (user.username !== '' && user.password != '') {
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.loggedIn.next(true);
        this.router.navigate(['/']);
      }
    });

  }

  logout() {
    this.loggedIn.next(false);
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

}
