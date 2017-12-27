import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  constructor( private http:HttpClient) { }

  hi(): Observable<any>{
    return this.http.get('http://localhost:8091/api/hi');
  }
}
