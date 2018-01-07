import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { environment } from '../../../environments/environment';

import { UserService } from '../../shared/user.service';
import { User } from '../../shared/user';

const API_URL = environment.apiUrl + "/users";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private username: string;
  private password: string;
  private email: string;
  private fname: string;
  private lname: string;
  private balance: number;

  private usernameWarning: string;
  private emailWarning: string;
  private balanceWarning: string;

  constructor(private http: HttpClient, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.usernameWarning = "";
    this.emailWarning = "";
    this.balanceWarning = "";
  }

  updateUsername(username: string) {
    this.username = username;
  }

  updatePassword(password: string) {
    this.password = password;
  }

  updateEmail(email: string) {
    this.email = email;
  }

  updateFirstname(fname: string) {
    this.fname = fname;
  }

  updateLastname(lname: string) {
    this.lname = lname;
  }

  updateBalance(balance: number) {
    this.balance = balance;
  }

  usernameBlur() {
      this.http.post<User>(API_URL + "/username", this.username).subscribe(resp =>{
        if (resp != null){
          this.usernameWarning = "This username already taken. Please enter another one!";
        } else{
          this.usernameWarning = "";
        }
      });
  }

  emailBlur() {
    var emailRegex = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
    if (emailRegex.test(this.email)) {
      this.http.post<User>(API_URL + "/email", this.email).subscribe(resp => {
          if (resp != null) {
            this.emailWarning = "This email already taken. Please enter another one!";
          } else {
            this.emailWarning = "";
          }
      });
    } else {
      this.emailWarning = "That is not a valid email address";
    }
  }

  balanceBlur() {
    if(this.balance < 0){
      this.balanceWarning = "Please enter a correct balance!";
    } else{
      this.balanceWarning = "";
    }
  }

  submit() {
    if (!(this.emailWarning || this.usernameWarning || this.balanceWarning) && this.username) {
      var user = new User();
      user.userId = 0;
      user.firstname = this.fname;
      user.lastname = this.lname;
      user.email = this.email;
      user.username = this.username;
      user.password = this.password;
      user.balance = this.balance;

      this.http.post<User>(API_URL, user).subscribe(res => {
        this.router.navigate([""]);
      });
    }
  }

  cancel() {
    this.router.navigate([""]);
  }
}


