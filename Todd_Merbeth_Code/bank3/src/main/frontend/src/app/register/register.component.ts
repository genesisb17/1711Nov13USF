import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { RegisterService } from '../register.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstname: string = '';
  lastname: string = '';
  email: string = '';
  username: string = '';
  password: string = '';

  constructor(private registerService: RegisterService, private router: Router) { }

  ngOnInit() {
    this.registerService.registerSubject.subscribe(acc => {
      if (acc == null){
        console.log("Error creating account");
      }
      else {
        this.router.navigate(["login"]);
      }
    });
  }

  register() {
    if (this.firstname.length > 0 && this.lastname.length > 0 && this.email.length > 0 && this.username.length > 0 && this.password.length > 0) {
      this.registerService.register(this.firstname, this.lastname, this.email, this.username, this.password);
    }
  }

  back() {
    this.router.navigate(["login"]);
  }

}
