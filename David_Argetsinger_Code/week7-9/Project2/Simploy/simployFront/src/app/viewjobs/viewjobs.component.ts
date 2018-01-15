import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Job } from '../job';
import { JobTable } from '../JobTable';
import { User } from '../user';
@Component({
  selector: 'app-viewjobs',
  templateUrl: './viewjobs.component.html',
  styleUrls: ['./viewjobs.component.css']
})
export class ViewjobsComponent implements OnInit 
{
  
  tableData:JobTable[];
  viewResume:boolean=false;
  viewJob:boolean = false;
  skillDatab:boolean=false;
  user:User;

  
company:any;
title:any;
location:any;
description:any;
  skills:any[];
  postDate:string;
  constructor(private http:HttpClient) { }

  ngOnInit() 
  {
    //this.getTableData();
    this.tableData=JSON.parse(localStorage.getItem('JobsTable'));
    console.log(this.tableData);
  }

  getTableData()
  {
    this.http.get('http://localhost:8088/Job')
    .subscribe(
      (data: Job[]) =>
      {

          for (var i = 0; i < data.length; i++){
            this.tableData[i].company=data[i].company;
            this.tableData[i].jobId=data[i].jobId;
            this.tableData[i].description=data[i].description;
            this.tableData[i].postDate=data[i].postDate;
            this.tableData[i].title=data[i].title;
            this.tableData[i].user=data[i].user;
            this.tableData[i].location=data[i].location
            for (var i = 0; i < data[i].skills.length; i++){
              this.tableData[i].skills+= data[i].skills[i].title+" ";
            }
          
          }
          console.log(this.tableData);
      }
    )
  }
  /*
(click)='getJobData(jobdata["company"],jobdata["title"],
              jobdata["location"],jobdata["desciption"],jobdata["postDate"],jobdata["skills"])'>
  */
  getJobData(company:any,title:any,location:any,description:any,postDate:any,skills1:string, user1:User)
  {
    /*
    this.id = id;
    
    
    this.role = 0;
    if (this.role == 1) {
      this.viewResume=true;
    }
    else {
      this.viewJob=true;
    }
    */
    this.skillDatab = true;
    this.viewJob = true;
    this.company = company;
    this.title = title;
    this.location = location;
    this.description = description;
    this.postDate = postDate;
    console.log(user1);
    this.user = user1;
    if (typeof skills1 == "string"){
    skills1 = skills1.trim();
    this.skills = skills1.split(" ");
    }else {
      this.skillDatab = false;
      this.skills = [];
    }
  }
}
