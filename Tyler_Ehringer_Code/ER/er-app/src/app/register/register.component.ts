import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { HttpClient } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';
import { BoolResult } from '../types/boolresult.type';
import * as $ from 'jquery';
import { User } from '../types/user.type';
import { last } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private username: string;
  private password1: string;
  private password2: string;
  private email: string;
  private role = 1;
  private firstName: string;
  private lastName: string;

  private usernameWarning: string;
  private emailWarning: string;
  private passwordWarning: string;

  constructor(private http: HttpClient, private account: AccountService) { }

  ngOnInit() {
    this.usernameWarning = "";
    this.emailWarning = "";
    this.passwordWarning = "";
    $(".role").click(() => {
      this.role = parseInt($(".role:checked").val());
    });
  }

  updateUsername(username: string) {
    this.username = username;
  }

  updatePassword1(password1: string) {
    this.password1 = password1;
  }

  updatePassword2(password2: string) {
    this.password2 = password2;
  }

  updateEmail(email: string) {
    this.email = email;
  }

  updateFirstname(firstname: string) {
    this.firstName = firstname;
  }

  updateLastname(lastname: string) {
    this.lastName = lastname;
  }

  usernameBlur() {
    if (this.username.length < 6) {
      this.usernameWarning = "Username must be at least 6 characters long";
    } else {
      this.http.get<BoolResult>("http://localhost:9999/ER/register/username",
        { params: new HttpParams().append("username", this.username) }).subscribe(resp => {
          if (resp.value) {
            this.usernameWarning = "Username already taken";
          } else {
            this.usernameWarning = "";
          }
        });
    }
  }

  passwordBlur() {
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/
    if (passwordRegex.test(this.password1)) {
      if (this.password1 == this.password2) {
        this.passwordWarning = "";
      } else {
        this.passwordWarning = "Your passwords do not match";
      }
    } else {
      this.passwordWarning = "Password must be at least 8 charactes long and have at least 1 upper case letter, 1 lower case letter, and 1 number";
    }
  }

  emailBlur() {
    var emailRegex = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
    if (emailRegex.test(this.email)) {
      this.http.get<BoolResult>("http://localhost:9999/ER/register/email",
        { params: new HttpParams().append("email", this.email) }).subscribe(resp => {
          if (resp.value) {
            this.emailWarning = "Email already taken";
          } else {
            this.emailWarning = "";
          }
        });
    } else {
      this.emailWarning = "That is not a valid email address";
    }
  }

  submit() {
    if (!(this.passwordWarning || this.emailWarning || this.usernameWarning) && this.username) {
      var user = new User();
      user.id = 0;
      user.email = this.email;
      user.fname = this.firstName;
      user.lname = this.lastName;
      user.password = this.password1;
      user.role = this.role;
      user.username = this.username;

      this.http.post<User>("http://localhost:9999/ER/register/new", [user], { withCredentials: true }).subscribe(res => {
        this.account.login(user.username, user.password);
      });
    }
  }
}
