import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {
  encryption: string;
  password: string;

  constructor() { }

  ngOnInit() {
  }

  encrypt(password: string){
    let result = "";
    for(let i = password.length-1; i >= 0; i--){
      result += password[i];
    }
    this.encryption = result;
  }

}
