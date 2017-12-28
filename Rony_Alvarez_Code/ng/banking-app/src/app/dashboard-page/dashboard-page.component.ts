import { User } from './../user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-page',
  templateUrl: './dashboard-page.component.html',
  styleUrls: ['./dashboard-page.component.css']
})

export class DashboardPageComponent implements OnInit {

  cookieValue = 'UNKNOWN';
  data = {
    email: '',
    password: ''
  }
  //user: User;
  user = {
    id: 0,
    firstname: '',
    lastname: '',
    email: '',
    password: '',
    balance: 0
  }

  constructor(private http: HttpClient, private cookieService: CookieService, private router: Router) { }

  ngOnInit() {

    this.cookieValue = this.cookieService.get('Test');
    this.data = JSON.parse(this.cookieValue);
    //console.log(this.data.email);

    if(this.cookieValue == 'UNKNOWN') {
      this.router.navigate(['/login']);
    }

    //this.cookieService.delete('Test');

    const body = this.data.email;

    const req = this.http.post('http://localhost:8092/api/user/findByEmail', body)
    .subscribe(
      res => {
        if(res == null) {
          console.log("Yay, it equals to null!");
        }
        
        //console.log(res['email']);

        this.user.firstname = res['firstname'];
        this.user.lastname = res['lastname'];
        this.user.email = res['email'];
        this.user.password = res['password'];
        this.user.balance = res['balance'];

        //console.log(this.user.email);

      },
      err => {
        console.log("An error occurred during the post request.");
        this.router.navigate(['/error']);
      }
    );


  }


  logout() {
    
    this.cookieService.delete('Test');
    this.router.navigate(['/login']);

  }



}
