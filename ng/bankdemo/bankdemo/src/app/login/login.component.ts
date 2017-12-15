import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  pass: string;
  username: string;

  constructor(private lgService: LoginService) { }

  ngOnInit() {
    this.lgService.subscribeToLogin(()=>{
      console.log("welcome " + this.username);
    }
  );
  }

  login(){
    this.lgService.login(this.username, this.pass);
  }

}
