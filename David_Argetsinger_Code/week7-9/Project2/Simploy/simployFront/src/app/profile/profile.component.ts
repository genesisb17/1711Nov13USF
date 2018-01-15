import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../user';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @ViewChild('profileF') profileF: NgForm;
  validInput: Boolean;

  user: User = JSON.parse(localStorage.getItem('user'));

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    console.log(this.user);
  }

  updateUser(e) {

    if (this.profileF.form.valid) {
      e.preventDefault();

      let EMAIL = e.target.elements[0].value;
      let FIRSTNAME = e.target.elements[1].value;
      let LASTNAME = e.target.elements[2].value;
      let PASSWORD = e.target.elements[3].value;
      let PNUMBER = e.target.elements[4].value;

      let json = {
        firstName: FIRSTNAME,
        lastName: LASTNAME,
        email: EMAIL,
        //pnumber: PNUMBER,
        pnumber:  '(' + PNUMBER.substring(0, 3) + ') ' + PNUMBER.substring(3, 6) + '-' + PNUMBER.substring(6, 10),
        password: PASSWORD,
        role: this.user.role,
        id: this.user.id
      };
      console.log(JSON.stringify(json));
      this.httpClient.post('http://localhost:8088/User/update', json).subscribe(
        (data: any) => {
          localStorage.setItem('user', JSON.stringify(data));
          this.user = data;
        }
      );

    }

  }

}
