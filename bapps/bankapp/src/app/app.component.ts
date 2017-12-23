import { Component } from '@angular/core';

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
}