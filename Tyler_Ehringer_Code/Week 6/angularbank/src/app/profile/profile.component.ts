import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../types/user.type';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  u: User;

  constructor(private user: UserService, private router: Router) { }

  ngOnInit() {
    this.u = this.user.user.getValue();
    this.user.user.subscribe(us => this.u = us);
  }

  submit() {
    this.user.update(this.u);
  }

  logout() {
    this.user.logout();
  }

  account() {
    this.router.navigate(["account"]);
  }
}
