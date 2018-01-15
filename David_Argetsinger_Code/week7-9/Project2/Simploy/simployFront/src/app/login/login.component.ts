import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('loginF') loginForm: NgForm;

  email: string = '';
  password: string = '';
  validInput: boolean;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.currentUser
    .subscribe(
      (user) => {
        if(user == null) {
          this.validInput = false;
        }
        else {
          this.validInput = true;
          this.router.navigate(['profile']);
        }
      }
    );
    this.validInput = true;
  }

  login() {
    this.loginService.login(this.email, this.password);

    if (this.validInput == false) {
      this.loginForm.form.markAsUntouched();
    }
  }

}
