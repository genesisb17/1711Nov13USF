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

  getUserByUsername(username: string): Observable<User> {
    let user = {
      username: username
    }
    return this.http.post<User>(`${apiUrl}/username`, httpOptions);
  }

  getUserByUsernameAndPassword(username: string, password: string): Observable<User> {
    let user = {
      username: username,
      password: password
    }
    return this.http.post<User>(`${apiUrl}/verify`, httpOptions);
  }

  updateUser(user: User): Observable<User> {
    return this.http.post<User>(`${apiUrl}`, httpOptions);
  }
}
