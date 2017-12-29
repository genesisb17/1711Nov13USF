import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  user : User;
  withAmount : number;
  depAmount : number;

  constructor(private router: Router, private uService: UserService, private lgService: LoginService) { }

  ngOnInit() {
    this.user = this.lgService.currentUser;
  }

  withdraw() {
    this.uService.updateUser(this.user, -this.withAmount)
  }

  deposit() {
    this.uService.updateUser(this.user, this.depAmount)
  }

  goBack() {
    this.router.navigate([""]);
  }
}
