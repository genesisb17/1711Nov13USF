import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { User } from '../types/user.type';
import * as $ from 'jquery';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private loginMessage = "not logged in";
  private loginAction = "Login";

  private isLoggedIn = false;

  constructor(private account: AccountService, private router: Router, private modal: NgbModal) {

   }

  ngOnInit() {
    this.onLogout();
    this.account.subscribeLogin(this.onLogin);
    this.account.subscribeLogout(this.onLogout);
  }

  onLogin = (success: boolean, user: User) => {
    this.loginMessage = "Welcome " + user.fname;
    this.isLoggedIn = true;
  }

  onLogout = () => {
    this.loginMessage = "not logged in";
    this.isLoggedIn = false;
  }  

  logout = () => {
    this.account.logout();
    this.router.navigate(["landing"]);
  }

  home() {
    if (this.account.isLoggedIn()) {
      this.router.navigate(["reimbursements"]);
    } else {
      this.router.navigate(["landing"]);
    }
  }
  openLogin() {
    this.modal.open(LoginComponent);
}

}
