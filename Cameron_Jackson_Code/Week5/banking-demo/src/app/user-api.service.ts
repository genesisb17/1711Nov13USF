import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserApiService {
  API_URL: string = environment.apiUrl;
  user: User;
  users: User[];
  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.API_URL}/users`);
  }

  getUser(id: number): Observable<User> {
      let url = `${this.API_URL}/users/${id}`;
      return this.http.get<User>(url);
  }

  addUser(user: User) {
    return this.http.post<User>(`${this.API_URL}/users`, {
      firstname: user.firstname,
      lastname: user.lastname,  
      username: user.username,
      password: user.password
    }, httpOptions);
  }

  

}
