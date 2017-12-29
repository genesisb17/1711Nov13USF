import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';
import { RegisterService } from '../register.service';
import { UpdateService } from '../update.service';
import { BalanceService } from '../balance.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  currentUser: User = JSON.parse(localStorage.getItem('user'));
  firstname: string = this.currentUser.firstname;
  lastname: string = this.currentUser.lastname;
  email: string = this.currentUser.email;
  balance: number = this.currentUser.balance;
  
  changeBalance: number;
  model: any = {};

  constructor(private route: Router, private update: UpdateService,
      private balanceService: BalanceService, private loginService: LoginService){ }

  ngOnInit() {
  }

  updateUser(){
    this.update.update(this.model);
  }

  withdraw(){
    this.balanceService.withdraw(this.changeBalance);
  }

  deposit(){
    this.balanceService.deposit(this.changeBalance);
  }

  logout(){
    this.loginService.logout();
    this.route.navigate(["login"]);
  }

}
