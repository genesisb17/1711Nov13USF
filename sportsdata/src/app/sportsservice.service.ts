import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class SportsserviceService {
data:any[];
  constructor(private http:HttpClient) { }
  getData(url:string)
  {
    this.http.get(url)
    .subscribe(
      (data:any[])=>
      {
          this.data=data;
          console.log(this.data);
      }
    ) 
  }
}
