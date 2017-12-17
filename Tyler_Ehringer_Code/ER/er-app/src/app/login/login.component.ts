import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import * as $ from 'jquery';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  private loginResult = "";

  constructor(private amodal: NgbActiveModal, private account: AccountService, private router: Router) { }

  ngOnInit() {

    $("#loginButton").click(() => {
      this.login();
    })
    this.account.subscribeLogin((result, user) => {
      if (!result) {
        this.loginResult = "Your username and password did not match";
      } else {
        this.loginResult = "";
        this.router.navigate(["reimbursements"]);
        this.amodal.close();
      }
    })
  }
  updateUsername(s: string) {
    this.username = s;
  }
  updatePassword(s: string) {
    this.password = s;
  }

  login() {
    this.account.login(this.username, this.password);
    

  }
}
