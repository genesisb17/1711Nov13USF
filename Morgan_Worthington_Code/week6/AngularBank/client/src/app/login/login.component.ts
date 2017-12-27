import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor( private router: Router,
               private user: UserService,
               private httpClient: HttpClient) { }

  ngOnInit() {
  }

  loginUser(e) {
    e.preventDefault();
    let user=e.target.elements[0].value;
    let pw=e.target.elements[1].value;
    let json = {
      username: user,
      password: pw
    };

    this.httpClient.post('http://localhost:8091/login', json).subscribe(
      (data: any) => {
        if (data.id == 0) {
          alert('Username and/or password are invalid.');
        } else {
          console.log(data);
          this.user.setUser(data);
          this.user.setUserLoggedIn();
          this.router.navigate(['/dashboard']);
        }
      }
    );
  }

  toRegister() {
    this.router.navigate(['/register']);
  }

}
