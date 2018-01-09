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
  value:number;
  username:string;
  password:string;
  spouse:string;
  constructor(private http:HttpClient) { }

  ngOnInit() 
  {
      this.postData("http://localhost:3000/user");
      this.getData("http://localhost:3000/user");
      this.value=0;
  }
  getData(url:string)
  {
    this.http.get(url)
    .subscribe(
      (data:any[])=>
      {
          this.data=data;
          console.log(this.data[0].username);
      }
    ) 
  }
  postData(url:string)
  {
    let json = 
    {
      id:10,
      username:"username2",
      password:"password2"
    };
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
  showInfo:boolean=false;

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
        this.spouse=this.data[i].relationuser;
        this.showInfo=true;
        console.log(this.username);
        }
      }
    }
  }
}