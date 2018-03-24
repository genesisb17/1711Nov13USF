import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable()
export class GetDataService {
  relations:any[];
  constructor(private http:HttpClient) { }
  getRData(url:string)
  {
    this.http.get(url)
    .subscribe(
      (data:any[])=>
      {
          this.relations=data;
          console.log(this.relations);
      }
    ) 
  }
}
