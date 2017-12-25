import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  currentUser: User;
  
  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
    let userStr: string = localStorage.getItem('currentUser');
    this.currentUser = new User();
    this.currentUser = JSON.parse(userStr);
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(["login"]);
  }
}
