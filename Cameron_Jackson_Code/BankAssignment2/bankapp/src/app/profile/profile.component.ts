import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userId: number;
  firstname: string;
  lastname: string;
  username: string;
  password: string;
  balance: number;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    let user: User = JSON.parse(localStorage.getItem('currentUser'));
    this.userId = user.userId;
    this.firstname = user.firstname;
    this.lastname = user.lastname;
    this.username = user.username;
    this.password = user.password;
    this.balance = user.balance;
  }

  ngOnInit() {
  }

  update() {
    let user = {
      userId: this.userId, // unbound
      firstname: this.firstname,
      lastname: this.lastname,
      username: this.username,
      password: this.password,
      balance: this.balance // unbound
    }
    this.loginService.update(user).subscribe((user) => {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.router.navigate(['/landing']);
    });
  }

}
