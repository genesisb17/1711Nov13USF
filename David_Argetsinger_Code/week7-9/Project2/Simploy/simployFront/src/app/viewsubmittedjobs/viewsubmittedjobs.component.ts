import { Router } from '@angular/router';
import { LoginService } from './../login.service';
import { JobTable } from './../JobTable';
import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { User } from '../user';
import { Job } from '../job';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs/Subject';


@Component({
  selector: 'app-viewsubmittedjobs',
  templateUrl: './viewsubmittedjobs.component.html',
  styleUrls: ['./viewsubmittedjobs.component.css']
})
export class ViewsubmittedjobsComponent implements OnInit {

  viewResume:boolean=false;
  viewJob:boolean = false;
  user: User = JSON.parse(localStorage.getItem('user'));

  id:number;
  email:any;
  firstname:any;
  lastname:any;
  phone:any;
  skills:any[];
  role:number;
  tableHold: JobTable[]=[];

  constructor(private httpClient:HttpClient, 
              private router: Router,
              private loginService: LoginService) { }

  ngOnInit() {
    this.getTableData();
    //this.tableHold = JSON.parse(localStorage.getItem('Jobs'));
  }

  getTableData()
  {
    let user: User = JSON.parse(localStorage.getItem('user'));
    let json = {
      id: user.id
    };
    this.httpClient.post('http://localhost:8088/Job/uidjobs', json)
    .subscribe(
      (data: Job[] ) =>
      {
        for (var i = 0; i < data.length; i++){
          let tableData:JobTable= new JobTable;
          tableData.company=data[i].company;
          tableData.jobId=data[i].jobId;
          tableData.description=data[i].description;
          tableData.postDate=data[i].postDate;
          tableData.title=data[i].title;
          tableData.user=data[i].user;
          tableData.location=data[i].location;
          if(data[i].skills.length > 0 ){
            tableData.skills = '';
          for (var j = 0; j < data[i].skills.length; j++){
            tableData.skills += data[i].skills[j].title + " "
          }}
          console.log(tableData.jobId);
          this.tableHold[i] = tableData;
        }
      }
    )
  }

  delete(w) {
let skillw: JobTable[] = new Array<JobTable>();
    skillw = (this.tableHold.splice(w, 1));
    console.log(skillw);

    const req = this.httpClient.post("http://localhost:8088/Job/delete",
    {
      "jobId" : skillw[0].jobId
    }
    )
      .subscribe(
      (res: JobTable) => {
        console.log("deleted " + res.jobId);
      },
      err => {
        console.log("Error occured");
      }
      );
  }

}
