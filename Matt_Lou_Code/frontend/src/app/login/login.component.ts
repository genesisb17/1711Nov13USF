import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.subscribeToLogin(() => {
      this.router.navigate(["landing"]);
    });
  }

  login(){
    if(this.username.length > 0 && this.password.length > 0){
      this.loginService.login(this.username, this.password);
    }
  }
}
