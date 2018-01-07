import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../shared/auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { User } from '../../shared/user';

const API_URL = environment.apiUrl + "/users";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  private username: string;
  private password: string;

  private message: string;

  constructor(private authService: AuthService, private router: Router, private http: HttpClient) { }

  ngOnInit() {
    this.message = "";
  }

  updateUsername(username: string) {
    this.message = "";
    this.username = username;
  }

  updatePassword(password: string) {
    this.message = "";
    this.password = password;
  }

  login() {
    if(!(this.message) && this.username && this.password){
      // this.authService.validate(this.username, this.password); 
      var user = new User();
      user.username = this.username;
      user.password = this.password;
      this.http.post<User>(API_URL + "/auth", user).subscribe(resp => {
        if(resp){
          localStorage.setItem("user", JSON.stringify(resp));
          this.router.navigate(["dashboard"]);
        } else{
          this.message = "Fail to login. Please make sure you have correct username and password";
        }
      });
    }  
  }

  register() {
    this.router.navigate(["register"]);
  }

}
