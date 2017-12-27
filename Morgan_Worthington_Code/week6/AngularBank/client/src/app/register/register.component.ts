import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router,
              private user: UserService,
              private httpClient: HttpClient) { }

  ngOnInit() {
  }

  registerUser(e) {
    e.preventDefault();
    let fn = e.target.elements[0].value;
    let ln = e.target.elements[1].value;
    let username = e.target.elements[2].value;
    let password = e.target.elements[3].value;
    let balance = e.target.elements[4].value;
    let json = {
      id: 0,
      fn: fn,
      ln: ln,
      username: username,
      pw: password,
      balance: balance
    };
    this.user.setUser(json);

    this.httpClient.post('http://localhost:8091/addUser', json).subscribe(
      (data: any)  => {
        if (data.check != 'valid') {
          alert('User already exists.');
        } else {
          this.user.setUserLoggedIn();
          this.router.navigate(['/dashboard']);
        }
      }
    );
  }

  backToLogin() {
    this.router.navigate(['/']);
  }
}
