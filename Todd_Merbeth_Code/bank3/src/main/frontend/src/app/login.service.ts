import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { environment } from '../environments/environment';
import { Account } from './account';

@Injectable()
export class LoginService implements CanActivate{

  public loginSubject = new BehaviorSubject<Account>(null);

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    this.http.post<Account>(environment.apiUrl + "/login", [username, password]).subscribe(acc => {
      if (acc) this.loginSubject.next(acc);
    });
  }

  logout(){
    this.loginSubject.next(null);
  }

  canActivate() {
    return this.loginSubject.getValue() != null;
  }
}
