import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  currentUser: User;
  isLoggedIn$: Observable<boolean>;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
    this.isLoggedIn$ = this.loginService.isLoggedIn;
    if (this.isLoggedIn$)
      this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  }
  
  logout() {
    this.loginService.logout();
    this.router.navigate(["login"]);
  }

}
