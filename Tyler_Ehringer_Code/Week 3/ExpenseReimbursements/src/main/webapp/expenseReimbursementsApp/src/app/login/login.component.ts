import * as $ from 'jquery';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router/src/router';
import { HttpClient } from '@angular/common/http'
import { LoginService } from '../login.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  constructor(private router: Router,private http: HttpClient, private login: LoginService) { }

  ngOnInit() {
    $("#loginButton").click(() => {
      let u = this.login.login(this.username, this.password);
    })
  }
  updateUsername(s: string) {
    this.username = s;
  }
  updatePassword(s: string) {
    this.password = s;
  }

}

