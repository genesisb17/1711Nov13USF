import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  pass: string;
  username: string;

  constructor(private lgService: LoginService, private router: Router) { }

  ngOnInit() {
    this.lgService.subscribeToLogin(()=>{
      this.router.navigate(["logged"])
    }
  );
  }

  login(){
    this.lgService.login(this.username, this.pass);
  }

}
