import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  password = '';
  username = '';
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.subscribeToLogin(() => {
      alert("You logged in!");
    })
  }

  login() {
    this.loginService.login(this.username, this.password);
  }

}