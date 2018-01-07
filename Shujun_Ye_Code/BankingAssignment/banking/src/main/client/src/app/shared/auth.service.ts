import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { environment } from '../../environments/environment';

import { User } from './user';
import { UserService } from './user.service';

const API_URL = environment.apiUrl + "/users";

@Injectable()
export class AuthService {

  currentUser: User;

  constructor(private http: HttpClient, private userService: UserService, private router: Router) { }

  // validate(username: string, password: string) {
  //   var auth = this.userService.getUserByUsernameAndPassword(username.toLowerCase(), password);
  //   console.log(auth);
  //   if(auth) {
  //     this.router.navigate(["dashboard"]);
  //   } else {
  //     console.log("fail to login");
  //   }
  // }
}
