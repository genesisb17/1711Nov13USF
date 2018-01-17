import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Account } from '../account';
import { Router } from '@angular/router';
import { UpdateAccountService } from '../update-account.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  public account: Account;
  deposit: number = 0.00;
  withdraw: number = 0.00;

  firstname: string = "";
  lastname: string = "";
  email: string = "";
  username: string = "";
  password: string = "";
  
  constructor(private loginService: LoginService, private update:UpdateAccountService, private router: Router) { }

  ngOnInit() {
    this.account = this.loginService.loginSubject.getValue();
    this.updateValues();
  }
  
  makeDeposit(){
    console.log("in deposit");
    this.update.updateSubject.subscribe(acc => {
      if (acc != null) {
        this.account = acc;
      }
    });
    this.update.deposit(this.account, this.deposit);
    this.deposit = 0.00;
  }

  makeWithdrawal(){
    console.log("in deposit");
    this.update.updateSubject.subscribe(acc => {
      if (acc != null) {
        this.account = acc;
      }
    });
    this.update.withdraw(this.account, this.withdraw);
    this.withdraw = 0.00;
  }

  makeUpdate(){
    this.update.updateSubject.subscribe(acc => {
      if (acc != null) {
        this.account = acc;
      }
    });
    this.update.update(this.account.id, this.firstname, this.lastname, this.email, this.username, this.password);
  }

  updateValues(){
    this.firstname = this.account.firstname;
    this.lastname = this.account.lastname;
    this.email = this.account.email;
    this.username = this.account.username;
    this.password = this.account.password;
  }

  doLogout(){
    this.loginService.logout();
    this.router.navigate(["login"]);
  }

}
