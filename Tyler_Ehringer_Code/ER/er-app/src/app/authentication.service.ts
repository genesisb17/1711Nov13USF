import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AccountService } from './account.service';

@Injectable()
export class AuthenticationService implements CanActivate{

  constructor(private account: AccountService, private router: Router) { }

  canActivate(): boolean {
    if (this.account.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate([""]);
      return false;
    }
  }

}
