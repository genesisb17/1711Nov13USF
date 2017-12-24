import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { UserApiService } from '../user-api.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  firstname: string;
  lastname: string;
  username: string;
  password: string;

  constructor(
    private loginService: LoginService
  ) { }

  ngOnInit() {
  }

  register() {
    let user = {
      firstname
    }
  }

}
