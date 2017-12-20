import { Injectable } from '@angular/core';
import{User} from './user';
import{HttpClient}from '@angular/common/http';
import{environment} from '../environments/environment';
@Injectable()
export class LoginService {

  API_URL:string = environment.apiUrl;
  currentUser:User;
  subscribers:Function[]=[];
  constructor(private http:HttpClient) { }

  login(username:string,password:string)
  {
    this.http.get<User[]>(this.API_URL+"/users").subscribe(users=>{users.filter(user=>{
      let filteredUsers = users.filter(user=>{
        user.name == username&&user.password==password;
      });
      if(filteredUsers.length>0)
      {
        this.currentUser=filteredUsers[0];
        this.subscribers.forEach(sub => 
        { 
          sub() 
        });
      }
      else
      {
        this.currentUser = null;
      }
    })
  })
  }
  subscribeToLogin(f: Function)
  {
    this.subscribers.push(f);
  }

}
