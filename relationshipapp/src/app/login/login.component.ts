import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  data:any[];
  relations:any[];
  value:number;
  username:string;
  password:string;
  spouse:string;
  constructor(private http:HttpClient) { }
  UserRelation:any[];
  r:any;
  onrelationKeyUp(event:any)
  {
    this.r = event.target.value;
  }
  addUserrelation()
  {
    //this.test.push(this.r);
  }
  ngOnInit() 
  {
      this.getData("http://localhost:3000/user");
      this.getRData("http://localhost:3000/relations");
      this.value=0;
  }
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
  showReg:boolean=false;
  register()
  {
    this.showReg=!this.showReg;
  }
  postData(url:string)
  {
    var json={username:"test",password:"test"};
    this.http.post(url, json).subscribe(
      (data: any[]) => 
      {
      }
    );
    console.log(json);
  }
  changeValue(n:number)
  {
    this.value=this.value+n;
  }
  name:string;
  onNameKeyUp(event:any)
  {
    this.name =event.target.value;
  }
  onPasswordKeyUp(event:any)
  {
    this.password =event.target.value;
  }
  showInfo1:boolean=false;
  u_id:any;
  getUserbyUsername()
  {
    var i =0;
    for(i=0;i<this.data.length;i++)
    {
      if(this.data[i].username==this.name)
      {
        if(this.data[i].password==this.password)
        {
         // this.u_id=this.data[i].
          this.username=this.name;
          this.showInfo1=!this.showInfo1;
          console.log(this.username);
        }
      }
    }
  }
}