import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from '../../shared/user';
import { environment } from '../../../environments/environment';

const API_URL = environment.apiUrl + "/users";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  private user: User = JSON.parse(localStorage.getItem("user"));

  private balance: number;
  private password: string;
  private balanceWarning: string;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.balanceWarning = "";
  }

  updateBalance(balance: number) {
    this.balance = balance;
  }

  balanceBlur() {
    if(this.balance < 0){
      this.balanceWarning = "Please enter a correct balance!";
    } else{
      this.balanceWarning = "";
    }
  }

  updatePassword(password: string) {
    this.password = password;
  }

  updateUser() {
    if(!(this.balanceWarning) && (this.balance || this.password)){
      if(this.balance && this.password){
        this.user.password = this.password;
        this.user.balance = this.balance;
      } else if(this.balance){
        this.user.balance = this.balance;
      } else{
        this.user.password = this.password;
      }
      this.http.put<User>(API_URL, this.user).subscribe(resp => {
        localStorage.setItem("user", JSON.stringify(resp));
        this.router.navigate(["dashboard"]);
      });
    }
  }

  cancel() {
    this.router.navigate(["dashboard"]);
  }
}
