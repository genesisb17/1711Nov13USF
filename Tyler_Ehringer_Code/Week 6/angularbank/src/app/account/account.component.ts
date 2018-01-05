import { Component, OnInit } from '@angular/core';
import { User } from '../types/user.type';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  u: User;
  amount: number = 0.00;
  action: string = "deposit";

  message = "";

  constructor(private user: UserService, private router: Router) { }

  ngOnInit() {
    this.u = this.user.user.getValue();
    this.user.user.subscribe(us => this.u = us);
  }

  deposit() {
    if (this.action == "withdraw" && this.amount > this.user.user.getValue().balance) {
      this.message = "Cannot withdraw more than your current balance";
    } else if (this.amount > 0) {
      this.user.deposit(this.u.id, this.action == "deposit" ? this.amount : -this.amount);
      this.message = "";
    } else {
      this.message = "You must " + this.action + " an amount greater than $0.00";
    }
  }

  logout() {
    this.user.logout(); 
  }

  profile() {
    this.router.navigate(["profile"]);
  }
}
