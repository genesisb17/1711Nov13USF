import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { User } from './../user';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})

export class RegisterPageComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  user: User;

  ngOnInit() {

    this.user = {
      id: 0,
      firstname: '',
      lastname: '',
      email: '',
      password: '',
      balance: 0
    }

  }

  processRegister() {
    
    const body = {
      firstname: this.user.firstname,
      lastname: this.user.lastname,
      email: this.user.email,
      password: this.user.password,
      balance: this.user.balance
    };

    const req = this.http.post('http://localhost:8092/api/user', body)
    .subscribe(
      res => {
        this.router.navigate(['/login']);
      },
      err => {
        console.log("An error occurred during the post request.");
      }
    );

  }

}
