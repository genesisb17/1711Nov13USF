import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './types/user.type';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../environments/environment';
import { CanActivate } from '@angular/router';


@Injectable()
export class UserService implements CanActivate {

  user: BehaviorSubject<User> = new BehaviorSubject(null);

  constructor(private http: HttpClient, private router: Router) { 
    let u = localStorage.getItem("user");
    if (u) this.user.next(JSON.parse(u));
  }

  usernameAvailable(username: string): Observable<boolean> {
    return this.http.post<boolean>(environment.apiUrl + "username", username, {withCredentials: true});
  }

  login(username: string, password: string): void {
    this.requestUser("login", [username, password]);
  }

  logout(): void {
    this.user.next(null);
    localStorage.removeItem("user");
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
      .subscribe(u => {
        this.user.next(u);
        localStorage.setItem("user", JSON.stringify(u));
      });
  }

  canActivate() {
    if (this.user.getValue() == null) {
      this.router.navigate(["login"]);
      return false;
    } 
    return true;
  }
}