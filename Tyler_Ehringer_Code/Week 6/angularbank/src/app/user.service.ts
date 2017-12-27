import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './types/user.type';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../environments/environment';


@Injectable()
export class UserService {

  user: BehaviorSubject<User> = new BehaviorSubject(null);

  constructor(private http: HttpClient, private router: Router) { }

  usernameAvailable(username: string): Observable<boolean> {
    return this.http.post<boolean>(environment.apiUrl + "username", username, {withCredentials: true});
  }

  login(username: string, password: string): void {
    this.requestUser("login", [username, password]);
  }

  logout(): void {
    this.user.next(null);
    this.router.navigate(["login"]);
  }

  register(u: User): void {
    this.requestUser("register", u);
  }

  deposit(uid: number, uamount: number): void {
    this.requestUser("deposit", { id: uid, amount: uamount });
  }

  update(us: User): void{
    this.requestUser("profile", us);
  }

  private requestUser(path: string, args): void{
    this.http.post<User>(environment.apiUrl + path, args, { withCredentials: true })
      .subscribe(u => this.user.next(u));
  }
}