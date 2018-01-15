import { User } from './../user';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { Job } from '../job';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-submitjob',
  templateUrl: './submitjob.component.html',
  styleUrls: ['./submitjob.component.css']
})
export class SubmitjobComponent implements OnInit {
  @ViewChild('summaryF') summaryForm: NgForm;
  @ViewChild('addSkillF') addSkillForm: NgForm;
  @ViewChild('jobF') jobForm: NgForm;

  selectedSkill = '';

  skills: string[] = ['Java', 'Angular', 'SQL', 'C++', 'Agile', 'AJAX'];

  yourskills: string = "";

  job: Job;
  toAddJob: boolean = true;
  toAddSkills: boolean = false;

  user: User = JSON.parse(localStorage.getItem('user'));

  constructor(private router: Router,
              private httpClient: HttpClient,
              private loginService: LoginService) { }

  ngOnInit() {
  }

  backToProfile() {
    //this.jobForm.reset();
    this.loginService.login(this.user.email, this.user.password);
    this.router.navigate(['/profile']);
  }

  submitJob(e) {

    if (this.jobForm.form.valid) {
      e.preventDefault();

      this.toAddJob = false;
      this.toAddSkills = true;
      let Company = e.target.elements[0].value;
      let Description = e.target.elements[1].value;
      let LOCATION = e.target.elements[2].value;
      let Title = e.target.elements[3].value;
      let Website = e.target.elements[4].value;
      let currentTime = new Date();
      let date = (currentTime.getMonth()+1).toString() + '/' + currentTime.getDate().toString() + '/' + currentTime.getFullYear().toString();
      let user: User = JSON.parse(localStorage.getItem('user'));
      console.log(date);
      let json = {
        description: Description,
        title: Title,
        location: LOCATION,
        company: Company,
        website: Website,
        postDate: date,
        user: {
          id: user.id
        }
      };
      this.httpClient.post('http://localhost:8088/Job', json).subscribe(
        (data: Job) => {
          this.job = data;
        }
      );
    }

  }

  addSkill() {
    if (!this.yourskills.includes(this.addSkillForm.value.newskill)) {
      this.yourskills += ' ' + this.addSkillForm.value.newskill;
      //finding skill id
      let sId: number;
      for ( let i = 0 ; i < this.skills.length; i++) {
        if (this.addSkillForm.value.newskill == this.skills[i]) {
          sId = i + 1;
        }
      }
      let json = {
        skills: [
          {
          skillId: sId,
          title: this.addSkillForm.value.newskill
        }
      ],
      jobId: this.job.jobId
    };

    console.log(json);

    this.httpClient.post('http://localhost:8088/Job/addskill', json).subscribe(
      (data: any) => {
        console.log('added new job skill');
      }
    );
    }
  }

done() {
  this.loginService.login(this.user.email, this.user.password);
}
}
