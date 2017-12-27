import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-lgin',
  templateUrl: './lgin.component.html',
  styleUrls: ['./lgin.component.css']
})

export class LginComponent implements OnInit {

  password:string;
  username:string;
  constructor(private LoginService:LoginService) { }

  ngOnInit() 
  {

    this.LoginService.subscribeToLogin(()=>
    {
      alert("you logged in");
    });

  }
  login()
  {
    this.LoginService.login(this.username,this.password);
  }

}