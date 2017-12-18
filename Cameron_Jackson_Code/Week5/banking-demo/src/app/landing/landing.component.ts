import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  currUser: User;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    console.log(this.loginService.currentUser);
  }

}
