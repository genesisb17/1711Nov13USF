import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../types/user.type';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username = "";
  password1 = "";
  password2 = "";
  fname = "";
  lname = "";

  usernameMessage = "";
  passwordMessage = "";

  constructor(private user: UserService, private router: Router) { }

  ngOnInit() {
    this.user.user.subscribe(u => {
      if (u != null) this.router.navigate(["account"]);
    });
  }

  usernameBlur() {
    this.user.usernameAvailable(this.username).subscribe(b => {
      this.usernameMessage = b ? "" : "That username is already taken";
    });
  }

  passwordBlur() {
    if (this.password2 && this.password1 != this.password2) {
      this.passwordMessage = "Your passwords do not match";
    } else this.passwordMessage = "";
  }

  register() {
    if (!(this.usernameMessage || this.passwordMessage)) {
      this.user.register(new User({
        username: this.username, password: this.password1,
        fname: this.fname, lname: this.lname
      }));
    }
  }

  login() {
    this.router.navigate(["login"]);
  }

}
