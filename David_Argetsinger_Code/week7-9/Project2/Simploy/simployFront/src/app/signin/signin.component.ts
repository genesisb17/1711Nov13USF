import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  inLogin: boolean = true;
  inRegister: boolean;

  constructor() { }

  ngOnInit() {
  }

  showLogin() {
    this.inLogin = true;
    this.inRegister = false;
  }

  showRegister() {
    this.inLogin = false;
    this.inRegister = true;
  }

}
