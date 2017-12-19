import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
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
    private loginService: LoginService,
    private uas: UserApiService) { }

  ngOnInit() {
  }

  register() {
    let newUser: User = new User();
    this.uas.addUser(newUser);
    
  }

}
