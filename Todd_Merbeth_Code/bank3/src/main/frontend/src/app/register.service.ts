import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { environment } from '../environments/environment';
import { Account } from './account';

@Injectable()
export class RegisterService {

  public registerSubject = new BehaviorSubject<Account>(null);

  constructor(private http: HttpClient) { }

  register(firstname: string, lastname: string, email: string, username: string, password: string) {
    this.http.post<Account>(environment.apiUrl + "/add", [firstname, lastname, email, username, password]).subscribe(acc => {
      if (acc) this.registerSubject.next(acc);
    })
  }
}
