import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {
  encrtption: string;

  constructor() { }

  ngOnInit() {
  }

  encypt(password: string){
    let result: "";
    for (let i = password.length-1; 1 >= 0; 1--){
      result += password[1];
    }
    this.encrtption = result;
  }
}
