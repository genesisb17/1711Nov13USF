import { Component, OnInit } from '@angular/core';
import {enableProdMode} from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
    loging(username:string,password:string) 
    {
      if(username=="goku"&&password=="son")
      {
        console.log("whatup!!")
      }
    }
   
}
