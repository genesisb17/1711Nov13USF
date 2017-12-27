import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class AuthGuardGuard implements CanActivate {

  constructor(private cookieService: CookieService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.log('checking guard username is' + this.cookieService.get('username'));
    if (this.cookieService.get('username')) {
      console.log('allowed');
      return true;
    }

    return false;
  }
}
