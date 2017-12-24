import { Injectable } from '@angular/core';
import { UserApiService } from './user-api.service';
import 'rxjs/add/operator/map';
import { User } from './user';

@Injectable()
export class LoginService {

  constructor(private uas: UserApiService) { }

  login(username: string, password: string) {
    return this.uas.getUserByUsernameAndPassword(username.toLowerCase(), password.toLowerCase())
      .map((user) => {
        localStorage.setItem("currentUser", JSON.stringify(user));
        return user;
      });
  }

  register(user: User) {
    return this.uas.updateUser(user).map((u) => {
      localStorage.setItem("currentUser", JSON.stringify(u));
      return u;
    });
  }

  logout() {
    localStorage.removeItem("currentUser");
  }
}
