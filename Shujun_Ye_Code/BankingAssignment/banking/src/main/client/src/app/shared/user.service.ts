import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';

import { environment } from '../../environments/environment';
import { User } from './user';

const API_URL = environment.apiUrl + "/users";
// const httpOptions = {
//   headers: new HttpHeaders({'Content-Type': 'application/json'})
// };

@Injectable()
export class UserService {

  private logg: string;

  constructor(private http: HttpClient) { }

  getAllUsers() {
    return this.http.get<User[]>(API_URL);
  }

  // getUserByUsernameAndPassword(username: string, password: string): Observable<User>{
  //   var user = new User();
  //   user.username = username;
  //   user.password = password;
    
  //   return this.http.post<User>(API_URL + "/auth", user)
  //     .map(res=> {
  //       return res.json().results.map(User)
  //     });

    // this.http.post<User>(API_URL + "/auth", user).subscribe(resp =>{
    //   console.log(resp);
    //   if(resp){
    //     user = resp;
    //     this.logg = "valid";
    //   } else{
    //     this.logg = "invalid";
    //   }
    // });
    // console.log(this.logg);

  //}
}
