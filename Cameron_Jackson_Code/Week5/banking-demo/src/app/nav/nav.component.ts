import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  currentUser: User;
  loggedIn: boolean = false;
  constructor() { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (this.currentUser != null) {
      this.loggedIn = true;
    }
  }

}
