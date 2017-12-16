import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {
  password: string;
  encryption: string;

  constructor() { }

  ngOnInit() {
  }

  encrypt(password: string) {
    let result = "";
    for(let i = 0; i < password.length; ++i) {
      result += String.fromCharCode(password.charCodeAt(i)+13);
    }
    this.encryption = result;
  }

  decrypt(password: string) {
    let result = "";
    for(let i = 0; i < password.length; ++i) {
      result += String.fromCharCode(password.charCodeAt(i)-13);
    }
    this.encryption = result;
  }
}
