import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserApiService } from '../user-api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title: string = "The Bank";
  username: string;
  password: string;
  returnUrl: string;

  constructor(
    private uas: UserApiService,
    private loginService: LoginService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.loginService.logout();
    this.uas.getAllUsers().subscribe((users) => {
      localStorage.setItem('users', JSON.stringify(users));
    });
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login() {
    let user = {
      userId: null,
      firstname: null,
      lastname: null,
      username: this.username,
      password: this.password,
      balance: null
    }
    this.loginService.login(user)
      .subscribe((data) => {
        this.router.navigate(["landing"]);
      });
  }
}
