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
  balance: number;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    // let userStr: string = localStorage.getItem('currentUser');
    // this.currentUser = new User();
    // this.currentUser = JSON.parse(userStr);
  }

  update() {
    this.loginService.update(this.currentUser).subscribe((user) => {
      localStorage.setItem('currentUser', JSON.stringify(user));
    });
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(["login"]);
  }
}
