import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { UserApiService } from '../user-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  firstname: string;
  lastname: string;
  username: string;
  password: string;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  register() {
    let user = {
      userId: null,
      firstname: this.firstname,
      lastname: this.lastname,
      username: this.username,
      password: this.password,
      balance: null
    }
    return this.loginService.register(user).subscribe((data) => {
      this.router.navigate(["landing"]);
    });
  }

}
