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
  pass: string;
  username: string;
  message: string;
  user: User = new User();

  constructor(private uService: UserService, private router: Router) {

   }

  ngOnInit() {
  }

  register(){
    this.user.password = this.pass;
    this.user.username = this.username;
    this.uService.addUser(this.user);
    console.log("added user");
    this.message = "Success! Please log in with your credentials";
    //setTimeout(this.router.navigate(["logged"]), 1000);
  }

  goBack() {
    this.router.navigate([""]);
  }
}
