import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "";
  password = "";
  message = "";

  constructor(private user: UserService, private router: Router) { }

  ngOnInit() {
    this.user.user.subscribe(u => {
      if (u != null) {
        this.router.navigate(["account"]);
      } else {
        this.message = "Your username and password do not match";
      }
    })
  }

  login() {
    this.user.login(this.username, this.password);
  }

  register() {
    this.router.navigate(["register"]);
  }

}
