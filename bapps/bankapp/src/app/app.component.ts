import { Component,OnInit } from '@angular/core';
import { UserdataService } from './userdata.service';
import {Http,Response} from '@angular/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent 
{
  inLogin: boolean = true;
  inRegister: boolean;
  showRegister() {
    this.inLogin = false;
    this.inRegister = true;
  }
  showLogin() {
    this.inLogin = true;
    this.inRegister = false;
  }
  u=[]
  ngOnInit()
  {
  }
}