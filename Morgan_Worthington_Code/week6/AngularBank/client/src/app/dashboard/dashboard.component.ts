import { UserService } from '../user.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router,
              private user: UserService,
              private httpClient: HttpClient) { }

  json = this.user.getUser();

  ngOnInit() {
  }

  updateUser(e) {
    e.preventDefault();
    let id = this.user.getUser().id;
    let fn = e.target.elements[0].value;
    let ln = e.target.elements[1].value;
    let username = e.target.elements[2].value;
    let password = e.target.elements[3].value;
    let balance = e.target.elements[4].value;
    this.json = {
      id: id,
      fn: fn,
      ln: ln,
      username: username,
      pw: password,
      balance: balance
    };
    this.user.setUser(this.json);

    this.httpClient.post('http://localhost:8091/updateUser', this.json).subscribe(
      (data: any) => {
        console.log(data);
      }
    );
  }

  logout() {
    this.user.setUser('');
    this.user.setUserLoggedOut();
    this.router.navigate(['/']);
  }
}
