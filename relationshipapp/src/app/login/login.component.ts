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
      //this.postData("http://localhost:3000/user");
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
          console.log(this.data[0].username);
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
  updateData(url:string)
  {
    let json = 
    {
      id:10,
      username:"username2",
      password:"password2"
    };
    //this.http.put(url,).subscribe()
      
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
         /* if(this.data[i].id==this.relations[0].u_id1)
          {
            console.log(this.relations[0].u_id2);
          }*/
          console.log(this.username);
        }
      }
    }
  }
}