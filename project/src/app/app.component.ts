import { Component } from '@angular/core';
import {Http,Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent 
{
  title = 'app';
  private apiURL ="http://localhost:1024/mvcdemo/Bank";
  //private apiURL ="http://pokeapi.co/api/v2";
  data:any={};
  constructor(private http:Http)
  {
    console.log("test");
    this.getContacts();
    this.getData();
  }
  getData()
  {
    return this.http.get(this.apiURL).map((res:Response)=>res.json());
  }
  getContacts()
  {
    this.getData().subscribe
    (data=>{
      console.log(data);
      this.data=data;
    })
  }
}