import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user: User = JSON.parse(localStorage.getItem('user'));
  isEmployer: boolean = this.user.role == 1;
  isJobSeeker: boolean = this.user.role == 0;


  constructor(private router: Router) { }

  ngOnInit() {
    console.log('in navbar');
    console.log(this.user);
  }

  logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('resume');
    localStorage.removeItem('JobsTable');
    localStorage.removeItem('Jobs');
  }

}
