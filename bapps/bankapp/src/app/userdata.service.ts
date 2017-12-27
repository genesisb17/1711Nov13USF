import { Injectable } from '@angular/core';
import{User} from './user';
import{HttpClient}from '@angular/common/http';
import{environment} from '../environments/environment';
import 'rxjs/add/operator/map';

@Injectable()
export class UserdataService 
{
  constructor(private http:HttpClient){}
  private url:string="http://localhost:1024/api/Bank/a";
  
  getUsers()
  {
    return this.http.get(this.url).map((response: Response)=>response.json());
  }

}