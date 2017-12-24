import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title: string = "The Bank";
  username: string;
  password: string;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  login() {
    let user = {
      userId: null,
      firstname: null,
      lastname: null,
      username: this.username,
      password: this.password,
      balance: null
    }
    this.loginService.login(user)
      .subscribe((data) => {
        this.router.navigate(["landing"]);
      });
  }

}
