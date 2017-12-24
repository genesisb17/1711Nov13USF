import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const apiUrl: string = `${environment.apiUrl}/user`;

@Injectable()
export class UserApiService {
  
  constructor(private http: HttpClient) { }

  getAllUsers() {
    return this.http.get<User[]>(apiUrl);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${apiUrl}/${id}`);
  }

  getUserByUsername(user: User): Observable<User> {

    return this.http.post<User>(`${apiUrl}/username`, user, httpOptions);
  }

  getUserByUsernameAndPassword(user: User): Observable<User> {
    return this.http.post<User>(`${apiUrl}/verify`, user, httpOptions);
  }

  updateUser(user: User): Observable<User> {
    return this.http.post<User>(`${apiUrl}`, user, httpOptions);
  }
}
