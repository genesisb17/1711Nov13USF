import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/share';
import { AsyncLocalStorage } from 'angular-async-local-storage';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  @Input()
  currentUser: User;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private localStorage: AsyncLocalStorage
  ) { }

  ngOnInit() {

  }

  logout() {
    this.loginService.logout();
    this.localStorage.removeItem("currentUser");
    this.router.navigate(["login"]);
  }
}
