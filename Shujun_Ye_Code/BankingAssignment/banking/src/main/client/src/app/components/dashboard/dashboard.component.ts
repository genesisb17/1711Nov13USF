import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { UserService } from '../../shared/user.service';
import { User } from '../../shared/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private user: User = JSON.parse(localStorage.getItem("user"));

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  logout(){
    localStorage.removeItem("user");
    this.router.navigate([""]);
  }

  updateUser(){
    this.router.navigate(["update"]);
  }

}
