import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Headers } from '@angular/http';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = {
    username: '',
    password: ''
  };

  constructor(private http: Http, private cookieService: CookieService, private router: Router) { }

  ngOnInit() {
  }

  submit() {
    this.http.post('http://localhost/users/login', this.user).subscribe(
      succ => {
        this.cookieService.set('username', this.user.username);
        this.cookieService.set('password', this.user.password);
        this.router.navigateByUrl('/super');

      },
      err => alert('failed to login')
    );
  }

  testCookies() {
    const customHeaders: Headers = new Headers();
    customHeaders.append('username', this.cookieService.get('username'));
    customHeaders.append('password', this.cookieService.get('password'));
    this.http.get('http://localhost/users', {headers: customHeaders }).subscribe();
  }

}
