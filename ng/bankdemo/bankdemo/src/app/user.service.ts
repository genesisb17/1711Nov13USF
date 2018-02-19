import { Injectable } from '@angular/core';
import { User } from './user';
import { environment } from '../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { error } from 'selenium-webdriver';

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

  public validateEmail(email: string){
    console.log("validating user with email " + email);
    return this.http.post<string>(API_URL+"/email", email, httpOptions);
  }

  public getUser(email: string){
    console.log("getting user with email"+ email );
    return this.http.post<string>(API_URL+"/byemail",email, httpOptions );
  }

}
