import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  user: User; 
  constructor(private lgService: LoginService) { }

  ngOnInit() {
    this.user = this.lgService.currentUser;
  }



}
