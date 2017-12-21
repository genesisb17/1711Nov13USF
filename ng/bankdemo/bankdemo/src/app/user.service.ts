import { Injectable } from '@angular/core';
import { User } from './user';
import { environment } from '../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const API_URL = environment.apiUrl + "/users";
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {

 


  constructor(private http: HttpClient) { }

  public getUsers(){
    return this.http.get<User[]>(API_URL);
  }

  public addUser(user: User){
    return this.http.post<User>(API_URL, user, httpOptions);
  }

}
