import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { LoginService } from '../login.service';
import { User } from '../user';
import { ResumeOracle } from '../ResumeOracle';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @ViewChild('registerF') registerForm: NgForm; 

  user: User=new User();

  firstname: string = '';
  lastname: string = '';
  email: string = '';
  phonenumber: number;
  password: string = '';
  role: number;

  confirmpass: string = '';
  roles: string[] = ['Employee', 'Employer'];
  
  validInput: boolean;
  validNumber: boolean;

  constructor(private loginService: LoginService, 
              private router: Router,
              private httpClient: HttpClient) { }

  ngOnInit() {

    // Preview Data
    // this.loginService.currentUser
    // .subscribe(
    //   (user) => {
    //     if(user == null) {
    //       this.validInput = false;
    //     }
    //     else {
    //       this.validInput = true;
    //       this.router.navigate(['profile']);
    //     }
    //   }
    // );
    // this.validInput = true;
  }

 register() {

    if (this.registerForm.form.value.role == 'Employee')
      this.role = 0;
    else
      this.role = 1;

    let pnumber: string;

    if (this.phonenumber != undefined) 
      pnumber = this.phonenumber.toString();
    else
      pnumber = '';

    if (pnumber.length != 10) {
      this.validNumber = false;
    }
    else {
      pnumber = '(' + pnumber.substring(0,3) + ') ' + pnumber.substring(3,6) + '-' + pnumber.substring(6,10);
      
      this.validNumber = true;

      this.user.firstName = this.firstname;
      this.user.lastName = this.lastname;
      this.user.email = this.email;
      this.user.phoneNumber = pnumber;
      this.user.password = this.password;
      console.log("the user is ");
      console.log(this.user);
      // Mock Data
      // if (this.loginService.register(this.user) != null) {
      //   this.validInput = true;
      //   console.log(this.validInput);
      // }
      // else {
      //   this.validInput = false;
      //   console.log(this.validInput);
      // }

      let json = {
        firstName: this.user.firstName,
        lastName: this.user.lastName,
        email: this.user.email,
        pnumber: this.user.phoneNumber,
        password: this.user.password,
        role: this.role
      };
      console.log(json);
      this.httpClient.post('http://localhost:8088/User/', json).subscribe(
        (data: User) => {
          if (data==null)
          this.validInput = false;
        else{
          this.validInput = true;
          this.user=data;
        }
          localStorage.setItem('user', JSON.stringify(data));
          this.user=data;
          console.log("this is user");
          console.log(this.user);
          if(this.user.role==0){

          this.httpClient.post('http://localhost:8088/Resume/',
          {
            "description": "",
            "user": {
                "id": this.user.id
            }
            
        }
        
        ).subscribe(  
            (data1: ResumeOracle) => {
              console.log("this is resume");
              console.log(data1);
              localStorage.setItem('resume', JSON.stringify(data1));
              this.router.navigate(['/profile']);
            }
          );}

        }
      );
    
  
  
    }
      if (this.validInput == false) {
        this.registerForm.form.markAsUntouched();
      }
    } 


  



}
