import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AsyncLocalStorage } from 'angular-async-local-storage';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  firstname: string;
  lastname: string;
  isLoggedIn: Observable<boolean>;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private localStorage: AsyncLocalStorage
  ) { }

  ngOnInit() {
    // this.isLoggedIn$ = this.loginService.isLoggedIn;
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.localStorage.getItem<User>("currentUser").subscribe((user) => {
      this.firstname = user.firstname;
      this.lastname = user.lastname;
    });
    this.loginService.loggedIn.next(true);
    // if (this.isLoggedIn) {

    // }

  }

  logout() {
    this.loginService.logout();
    this.router.navigate(["login"]);
  }

}
