import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResumeOracle } from '../ResumeOracle';
import { ResumeTable } from '../ResumeTable';
@Component({
  selector: 'app-viewresumes',
  templateUrl: './viewresumes.component.html',
  styleUrls: ['./viewresumes.component.css']
})
export class ViewresumesComponent implements OnInit 
{   
  ProjectData:any[];
  RealData:ResumeTable[];
  viewResume:boolean=false;
  viewJob:boolean = false;
  constructor(private http:HttpClient) { }
  id:number;
  skillsarray:any[]=new Array();
  phone:string;
  email:string;
  first:string;
  last:string;
  skills:string[];
  role:number;
  projectDataelement:any[];
  count =0;
  ngOnInit() 
  {

    this.getRealData();
    this.getProjectData();
    this.getCertData();
    this.getEduData();
    this.getExpData();
  }
  certData:any[];
  getCertData()
  {
    this.http.get("http://localhost:8088/Certification")
    .subscribe(
      (data:any[])=>
      {
          this.certData=data;
          console.log(this.certData[0].resume.resId);
          console.log("yay");
      }
    ) 
  }
  certDataelement:any[];
  certDataArray:any[];
  findbyIdCert(id:number)
  {
    var i;
    this.certDataelement=[];
    var length;
    this.certDataArray=[];
  for(i=0;i<this.certData.length;i++)
  {
    if(id==this.certData[i].resume.resId)
    {
        this.certDataelement=this.certData[i];
        this.certDataArray.push(this.certDataelement);
        console.log(this.certDataArray[0]);
    }
  }
}
  getProjectData()
  {
    this.http.get("http://localhost:8088/Project")
    .subscribe(
      (data:any[])=>
      {
          this.ProjectData=data;
          console.log(this.ProjectData[0].resume.resId);
          console.log("yay");
      }
    ) 
  }
  ProjectDataArray:any[]=new Array();
  findbyIdProject(id:number)
  {
    var i;
    this.projectDataelement=[];
    var length;
    this.ProjectDataArray=[];
  for(i=0;i<this.ProjectData.length;i++)
  {
    if(id==this.ProjectData[i].resume.resId)
    {
        this.projectDataelement=this.ProjectData[i];
        this.ProjectDataArray.push(this.projectDataelement);
        console.log(this.ProjectDataArray[0]);
    }
  }
}
getRealData()
{
  this.RealData=JSON.parse(localStorage.getItem('ResumeTable'));
  console.log(this.RealData);

}
eduData:any[];
getEduData()
  {
    this.http.get("http://localhost:8088/Education")
    .subscribe(
      (data:any[])=>
      {
          this.eduData=data;
          console.log(this.eduData[0].resume.resId);
      }
    ) 
  }
  eduDataelement:any[];
  eduDataArray:any[];
  findbyIdEdu(id:number)
  {
    var i;
    this.eduDataelement=[];
    var length;
    this.eduDataArray=[];
  for(i=0;i<this.eduData.length;i++)
  {
    if(id==this.eduData[i].resume.resId)
    {
        this.eduDataelement=this.eduData[i];
        this.eduDataArray.push(this.eduDataelement);
        console.log(this.eduDataArray[0]);
    }
  }
}


expData:any[];
getExpData()
  {
    this.http.get("http://localhost:8088/Experience")
    .subscribe(
      (data:any[])=>
      {
          this.expData=data;
          console.log(this.expData[0].resume.resId);
      }
    ) 
  }
  expDataelement:any[];
  expDataArray:any[];
  findbyIdExp(id:number)
  {
    var i;
    this.expDataelement=[];
    var length;
    this.expDataArray=[];
  for(i=0;i<this.expData.length;i++)
  {
    if(id==this.expData[i].resume.resId)
    {
        this.expDataelement=this.expData[i];
        this.expDataArray.push(this.expDataelement);
        console.log(this.expDataArray[0]);
    }
  }
}
getUserData(id:number,phone:string,email:string,first:string,last:string,skills:string,user_id:number,role:number)
{
    if (role == 1) 
    {
      this.viewResume=true;
    }
    else 
    {
      this.viewJob=true;
    }
    this.id = id;
    this.first=first;
    this.last=last;
    this.email = email;
    this.phone = phone;
    this.skills=skills.trim().split(" ");
    console.log("skills" + skills);
    console.log(this.skills[0]);
    var i=0;
    var j;
    this.skillsarray=[];
    this.findbyIdProject(id);
    this.findbyIdCert(id);
    this.findbyIdEdu(id);
    this.findbyIdExp(id);
    for(i=0;i<this.RealData.length;i++)
    {
      //console.log(this.RealData[i].resId+" "+user_id)
      if(this.RealData[i].resId==user_id)
      {
        for(let i = 0 ; i < this.skills.length; i++)
        {
          this.skillsarray.push(this.skills[i]);
        }
      }
    }
  }
}
