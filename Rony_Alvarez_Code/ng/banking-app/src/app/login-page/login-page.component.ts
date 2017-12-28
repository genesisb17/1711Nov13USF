import { CookieService } from 'ngx-cookie-service';
import { User } from './../user';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from "@angular/router";

export class LoginInfo {
  email: '';
  password: '';
}

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})

export class LoginPageComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router, private cookieService: CookieService) { }

  user: LoginInfo;
  valid: Boolean = false;
  cookieValue = 'UNKNOWN';

  ngOnInit(): void {

    this.user = {
      email: '',
      password: ''
    }

    // this.http.get<User>('http://localhost:8092/api/user').subscribe(
    //   data => {
    //     console.log("Firstname: " + data[0].firstname);
    //     console.log("Lastname: " + data[0].lastname);
    //     console.log("Email: " + data[0].email);
    //   },
    //   (err: HttpErrorResponse) => {
    //     if (err.error instanceof Error) {
    //       console.log("Client-side error");
    //     } else {
    //       console.log("Server-side error has occured.");
    //     } 
    //   }
    // )

    // const body = 'ronyalvarez1993@gmail.com';

    // const req = this.http.post('http://localhost:8092/api/user/findByEmail', body)
    // .subscribe(
    //   res => {
    //     if(res == null) {
    //       console.log("Yay, it equals to null!");
    //       //this.router.navigate(['/error']);
    //     }
    //     //console.log(res);
    //   },
    //   err => {
    //     console.log("An error occurred during the post request.");
    //     this.router.navigate(['/error']);
    //   }
    // );

  }

  processForm() {
    //console.log(this.user);

    const body = {
      email: this.user.email,
      password: this.user.password
    };

    //console.log(body);

    const req = this.http.post('http://localhost:8092/api/user/findByEmailAndPassword', body)
    .subscribe(
      res => {
        //console.log(res);
        if(res == null) {
          this.valid = true;
          //this.router.navigate(['/error']);
        } else {
          this.cookieService.set( 'Test', JSON.stringify(body) );
          // this.cookieValue = this.cookieService.get('Test');
          //console.log(this.cookieValue);
          this.router.navigate(['/dashboard']);
        }
      },
      err => {
        console.log("An error occurred during the post request.");
        //this.router.navigate(['/error']);
      }
    );
  }

  // get diagnostic() {
  //   return JSON.stringify(this.user);
  // }

}
