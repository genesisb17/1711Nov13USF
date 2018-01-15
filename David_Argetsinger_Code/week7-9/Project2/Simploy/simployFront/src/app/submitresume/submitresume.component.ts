import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CertificateObj } from '../certificate';
import { Project } from '../project';
import { Education } from '../education';
import { Experiecne } from '../experience';
import { User } from '../user';
import { Resume } from '../Resume';
import { ResumeOracle } from '../ResumeOracle';
import { HttpClient } from '@angular/common/http';
import { Educations } from '../Educations';
import { timeout } from 'q';
import { Skill } from '../Skill';
import { Skills } from '../Skills';
import { Certifications } from '../Certifications';

@Component({
  selector: 'app-submitresume',
  templateUrl: './submitresume.component.html',
  styleUrls: ['./submitresume.component.css']
})
export class SubmitresumeComponent implements OnInit {
  [x: string]: any;
  @ViewChild('summaryF') summaryForm: NgForm;
  @ViewChild('addSkillF') addSkillForm: NgForm;
  @ViewChild('eduF') educationForm: NgForm;
  @ViewChild('certF') certForm: NgForm;
  @ViewChild('expF') expForm: NgForm;
  @ViewChild('projectF') projectForm: NgForm;

  summary = '';
  selectedSkill = '';

  skills: string[] = ['Java', 'Angular', 'SQL', 'C++', 'Agile', 'AJAX'];
  yourskills: Skill[] = [];
  edutypes: string[] = ['Bachelors', 'Masters', 'Associates'];
  educations: Educations[] = [];
  education: Educations = new Educations();

  certifs: Certifications[] = [];
  certif: Certifications = new Certifications();

  explist: Experiecne[] = [];
  exp: Experiecne = new Experiecne();

  projects: Project[] = [];
  project: Project = new Project();
  user: User;
  resume: ResumeOracle;
  description: string;
  constructor(private http: HttpClient) { }
  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.resume = JSON.parse(localStorage.getItem('resume'));
    console.log(this.resume);
    this.description = this.resume.description;
    this.initCertifications();
    this.initEducation();
    this.initExperience();
    this.initProject();
    this.initSkill();
  }

  initSkill() {
    if (this.resume.skills.length > 0) {
      for (let j = 0; j < this.resume.skills.length; j++) {
        this.yourskills.push(this.resume.skills[j]);
      }
    }
  }



  initCertifications() {
    const req = this.http.post("http://localhost:8088/Certification/resid",
    {
      "resId": this.resume.resId
})
      .subscribe(
      (res: Certifications[]) => {
        for (let i = 0; i < res.length; i++) {
        this.certifs.push(res[i]);
        }
      },
      err => {
        console.log("Error occured");
      }
      );



  }

  initExperience() {
    const req = this.http.post("http://localhost:8088/Experience/resid",
    {
      "resId": this.resume.resId
})
      .subscribe(
      (res: Experiecne[]) => {
        for (let i = 0; i < res.length; i++) {
        this.explist.push(res[i]);
        }
      },
      err => {
        console.log("Error occured");
      }
      );



  }


  //grab all educations by resid 

  initEducation() {
    const req = this.http.post("http://localhost:8088/Education/resid",
      {
        "resId": this.resume.resId
      })
      .subscribe(
      (data: Educations[]) => {

        /*
         localStorage.removeItem("Educations");
         localStorage.setItem('Educations',JSON.stringify(res));
         */
        for (let i = 0; i < data.length; i++) {
          this.educations.push(data[i]);
        }
      },
      err => {
        console.log("Error occured");
      }
      );
  }

  initProject() {
    const req = this.http.post("http://localhost:8088/Project/resid",
      {
        "resId": this.resume.resId  
      })
      .subscribe(
      (data: Project[]) => {

        /*
         localStorage.removeItem("Educations");
         localStorage.setItem('Educations',JSON.stringify(res));
         */
        for (let i = 0; i < data.length; i++) {
          this.projects.push(data[i]);
        }
      },
      err => {
        console.log("Error occured");
      }
      );
  }


  updateSummary() {
    //this.summary = this.summaryForm.value.description;
    this.resume.description = this.description;
    const req = this.http.post("http://localhost:8088/Resume/",
      {
        "user": {
          "id": this.resume.user.id
        },
        "description": this.resume.description,
        "resId": this.resume.resId
      })
      .subscribe(
      res => {
        localStorage.removeItem("resume");
        localStorage.setItem('resume', JSON.stringify(res));
      },
      err => {
        console.log("Error occured");
      }
      );
  }



  addSkill() {
    let exist: boolean = false;
    for (let i = 0; i < this.yourskills.length; i++) {
      if (this.yourskills[i].title == this.addSkillForm.value.newskill) {
        exist = true;
      }
    }

    if (exist == false) {
      let hold: Skill = new Skill;
      hold.title = this.addSkillForm.value.newskill;

      if (this.addSkillForm.value.newskill == 'Java') {
        hold.skillId = 1;
      }
      if (this.addSkillForm.value.newskill == 'Angular') {
        hold.skillId = 2;
      }
      if (this.addSkillForm.value.newskill == 'SQL') {
        hold.skillId = 3;
      }
      if (this.addSkillForm.value.newskill == 'C++') {
        hold.skillId = 4;
      }
      if (this.addSkillForm.value.newskill == 'Agile') {
        hold.skillId = 5;
      }
      if (this.addSkillForm.value.newskill == 'AJAX') {
        hold.skillId = 6;
      }
      this.yourskills.push(hold);
      const req = this.http.post("http://localhost:8088/Resume/addskill",
        {
          "skills": [
            {
              "skillId": hold.skillId,
              "title": this.addSkillForm.value.newskill

            }],
          "resId": this.resume.resId
        })
        .subscribe(
        res => {
          localStorage.removeItem("resume");
          localStorage.setItem('resume', JSON.stringify(res));
        },
        err => {
          console.log("Error occured");
        }
        );
    }
  }

  
  updateEducations() {
    //console.log(this.educationForm.form);
    const req = this.http.post("http://localhost:8088/Education",
      {
        "school": this.educationForm.form.value.school,
        "type": this.educationForm.form.value.edutype,
        "gradYear": this.educationForm.form.value.gradyear,
        "resume": {
          "resId": this.resume.resId
        }
      })
      .subscribe(
      (res: Educations) => {
        /*
         localStorage.removeItem("Educations");
         localStorage.setItem('Educations',JSON.stringify(res));
         */

        this.educations.push(res);
      },
      err => {
        console.log("Error occured");
      }
      );
  }


  deleteSkill(w) {
    let skillw: Skill[] = new Array<Skill>();
    skillw = (this.yourskills.splice(w, 1));
    console.log(skillw);

    const req = this.http.post("http://localhost:8088/Resume/deleteskill",
    {
      "skills" :[
        {
          "skillId":skillw[0].skillId,
          "title":skillw[0].title
          
        }
      ],
      "resId": this.resume.resId
        
    }
    )
      .subscribe(
      (res: ResumeOracle) => {
        localStorage.removeItem("resume");
        localStorage.setItem('resume', JSON.stringify(res));
      },
      err => {
        console.log("Error occured");
      }
      );

  }





  deleteEducation(i) {
    let edu: Educations[] = new Array<Educations>();
    edu = (this.educations.splice(i, 1));

    const req = this.http.post("http://localhost:8088/Education/delete",
      {
        "edu_id": edu[0].edu_id
      })
      .subscribe(
      (res: Educations) => {
        console.log("deleted " + res.edu_id)
      },
      err => {
        console.log("Error occured");
      }
      );

  }


  updateCertificates() {

    const req = this.http.post("http://localhost:8088/Certification",
    {
      "title": this.certForm.value.title,
      "gotYear": this.certForm.value.gotYear,
      "resume": {
        "resId": this.resume.resId
      }
    })
    .subscribe(
    (res: Certifications) => {

      this.certifs.push(res);

    },
    err => {
      console.log("Error occured");
    }
    );
  }

  deleteCert(i) {

    let cert: Certifications[] = new Array<Certifications>();
    cert = (this.certifs.splice(i, 1));

    const req = this.http.post("http://localhost:8088/Certification/delete",
      {
        "cert_id": cert[0].cert_id
      })
      .subscribe(
      (res: Certifications) => {
        console.log("deleted " + res.cert_id)
      },
      err => {
        console.log("Error occured");
      }
      );
  }


  updateExpList() {
    const req = this.http.post("http://localhost:8088/Experience",
    {
      "company": this.expForm.form.value.company,
      "title": this.expForm.form.value.title,
      "startYear":this.expForm.form.value.startyear,
      "endYear": this.expForm.form.value.endyear,
      "resume": {
        "resId": this.resume.resId
      }
    })
    .subscribe(
    (res: Experiecne) => {

      this.explist.push(res);


    },
    err => {
      console.log("Error occured");
    }
    );
  }

  deleteExperience(i) {

    let exper: Experiecne[] = new Array<Experiecne>();
    exper = (this.explist.splice(i, 1));
    const req = this.http.post("http://localhost:8088/Experience/delete",
    {
      "expId": exper[0].expId
    })
      .subscribe(
      (res: Experiecne) => {
        console.log("deleted " + res.expId)
      },
      err => {
        console.log("Error occured");
      }
      );
  }


  updateProjects() {

    const req = this.http.post("http://localhost:8088/Project",
    {
      "description": this.projectForm.form.value.description,
      "startDate": this.projectForm.form.value.startDate,
      "endDate":this.projectForm.form.value.endDate,
      "title": this.projectForm.form.value.title,
      "groupSize": this.projectForm.form.value.groupSize,
      "resume": {
        "resId": this.resume.resId
      }
    })
    .subscribe(
    (res: Project) => {

      this.projects.push(res);


    },
    err => {
      console.log("Error occured");
    }
    );

  }

  deleteProject(i) {
    let projk: Project[] = new Array<Project>();
    projk=(this.projects.splice(i, 1));
    console.log(projk);
    console.log(projk[0].proId);
    const req = this.http.post("http://localhost:8088/Project/delete",
    {
      "proId": projk[0].proId
    })
      .subscribe(
      (res: Project) => {
        console.log("deleted " + res.proId)
      },
      err => {
        console.log("Error occured");
      }
      );



    
  }

}
