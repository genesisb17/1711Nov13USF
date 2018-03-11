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

  ngOnInit() 
  {
    let json = {username:"username3",password:"password3"};
      this.getData("localhost:8097/api/PeopleKnower/all");
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
  showReg:boolean=false;
  register()
  {
    this.showReg=!this.showReg;
  }
  updateData(url:string)
  {
    let json = 
    {
      id:100,
      username:"username2",
      password:"password2"
    };
    this.http.put(url,json).subscribe(
      (data:any[])=>
      {
      }
    );
  }
  postData(url:string,json:any)
  {
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

  getUserbyUsername()
  {
    var i =0;
    for(i=0;i<this.data.length;i++)
    {
      if(this.data[i].username==this.name)
      {
        if(this.data[i].password==this.password)
        {
          this.username=this.name;
          this.showInfo1=!this.showInfo1;
          console.log(this.username);
        }
      }
    }
  }
}