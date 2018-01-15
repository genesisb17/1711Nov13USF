import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { User } from './user';
import { Job } from './job';
import { JobTable } from './JobTable';
import { Resume } from './Resume';
import { ResumeOracle } from './ResumeOracle';
import { ResumeTable } from './ResumeTable';

@Injectable()
export class LoginService {
  currentUser: BehaviorSubject<User> = new BehaviorSubject(null);

  tableHold: JobTable[] = [];
  tableHoldRes: ResumeTable[]= [];
  user1: User = new User;
  constructor(private http: HttpClient) { }

  login(email: string, password: string) {
    this.http.post('http://localhost:8088/User/login', {
      email: email,
      password: password
    })
      .subscribe(
      (data1: User) => {
        if (data1 == null){
          this.currentUser.next(data1);
        } else {
          this.currentUser.next(data1);
          localStorage.setItem('user', JSON.stringify(data1));
          this.user1.id = data1.id;
          if (data1.role == 0) {
            this.getTableDataJobSearcher();
           this.getResume();
          } else {
            this.getTableDataJobPoster();
            this.getGroupResume();
          }
        }
      }
      );
  }

   getResume() {
     this.http.post('http://localhost:8088/Resume/uid', this.user1)
       .subscribe(
       (data: ResumeOracle) => {
         let tableData: ResumeOracle = new ResumeOracle;

         if (data == null){
           localStorage.setItem('resume', JSON.stringify(tableData));
           return;

         }
         tableData.user = data.user;
         tableData.resId = data.resId;
         tableData.description = data.description;
         if (data.skills.length > 0) {
             tableData.skills = data.skills;
         }
         else 
         tableData.skills=[];
         localStorage.setItem('resume', JSON.stringify(tableData));
       }
       )
   }

  getTableDataJobPoster() {
    this.http.post('http://localhost:8088/Job/uidjobs',
    {
      "id" : this.user1.id
    }
  )
      .subscribe(
      (data: Job[]) => {

        for (var i = 0; i < data.length; i++) {
          let tableData: JobTable = new JobTable;
          tableData.company = data[i].company;
          tableData.jobId = data[i].jobId;
          tableData.description = data[i].description;
          tableData.postDate = data[i].postDate;
          tableData.title = data[i].title;
          tableData.user = data[i].user;
          tableData.location = data[i].location;
          if (data[i].skills.length > 0) {
            tableData.skills = "";
            for (var j = 0; j < data[i].skills.length; j++) {
              tableData.skills += data[i].skills[j].title + " "
            }
          }
          this.tableHold[i] = tableData;

        }
        localStorage.setItem('Jobs', JSON.stringify(this.tableHold));
      }
      )
  }

  getGroupResume() {
    this.http.get('http://localhost:8088/Resume')
      .subscribe(
      (data: ResumeOracle[]) => {
      
        for (let i = 0; i < data.length; i++) {
          this.tableHoldRes[i]=new ResumeTable();
          this.tableHoldRes[i].description = data[i].description;
          this.tableHoldRes[i].resId = data[i].resId;
          this.tableHoldRes[i].user = data[i].user;
          if (data[i].skills.length > 0) {
            this.tableHoldRes[i].skills='';
            for (let j = 0; j < data[i].skills.length; j++){
              this.tableHoldRes[i].skills+= data[i].skills[j].title+" ";
            }
        }
        }
        console.log(this.tableHoldRes);
        localStorage.setItem('ResumeTable', JSON.stringify(this.tableHoldRes));
      }
      )
  }


  getTableDataJobSearcher() {
    this.http.get('http://localhost:8088/Job')
      .subscribe(
      (data: Job[]) => {

        for (var i = 0; i < data.length; i++) {
          let tableData: JobTable = new JobTable;
          tableData.company = data[i].company;
          tableData.jobId = data[i].jobId;
          tableData.description = data[i].description;
          tableData.postDate = data[i].postDate;
          tableData.title = data[i].title;
          tableData.user = data[i].user;
          tableData.location = data[i].location;
          if (data[i].skills.length > 0) {
            tableData.skills = "";
            for (var j = 0; j < data[i].skills.length; j++) {
              tableData.skills += data[i].skills[j].title + " "
            }
          }
          console.log("skills" + tableData.skills);
          this.tableHold[i] = tableData;

        }
        localStorage.setItem('JobsTable', JSON.stringify(this.tableHold));
      }
      )
  }



  register(user: User) {

    // Mock Data
    if (user.email == 'test@t')
      return user;
    else
      return null;

    // Preview Data
    // this.http.post('http://localhost:8086/User/register', {
    //   email: email
    // })
    //   .subscribe(
    //   (data: User) => {
    //     if (data == null)
    //       this.currentUser.next(data);
    //     else
    //       this.currentUser.next(data);
    //   }
    //   );
  }

}
