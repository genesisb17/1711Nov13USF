import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  firstname: string;
  lastname: string;
  password: string;
  email: string;
  message: string;
  user: User = new User();
  valid: boolean = false;
  registered: boolean = false;

  // add password validation?
  constructor(private uService: UserService, private router: Router) {}

  ngOnInit() {}

  fullForm() {
    this.message="";
    console.log(`firstname: ${this.firstname} lastname: ${this.lastname} password: ${this.password} email: ${this.email}`);
    if (this.firstname != null && this.lastname != null && this.password != null && this.email != null) {
      this.register();
    }
    else {
      this.message = "Please fill out all fields!";
      this.valid = true;
    }

  }

  setUser(){
    this.user.firstname = this.firstname;
    this.user.lastname = this.lastname;
    this.user.password = this.password;
    this.user.email = this.email;
  }

  validateEmail() {
    this.message="";
    this.valid=false;
    console.log("blurred; in validate email");
    if (this.email != null) {
      let exists = this.uService.validateEmail(this.email)
        .subscribe(
        (exists) => {
          console.log("inside of subscribe printing exists" + exists);
          if (exists) {
           this.message = "Sorry, this email address is already being used. please try another";
            this.valid = true;
          }
        },
        error => console.log(error)
        )
    }
  }

  register() {
    this.setUser();
    console.log("adding user" + this.firstname + this.lastname);
    this.uService.addUser(this.user)
    .subscribe(
      (user)=>this.message = `Congratulations ${user.firstname}! Welcome to the app! Please log in with your credentials`
    );
    this.registered = true;

  }

  toLogin(){
    this.router.navigate([""]);
  }

}
