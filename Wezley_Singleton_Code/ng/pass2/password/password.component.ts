import { Component } from '@angular/core';

@Component({
  selector: 'password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent {

  encryption: string;

  constructor() { }

  //users Caesar cipher
  encrypt(input: string) {
    let key = 14;
    let result = ""

    result = input.replace(/([a-z])/g, 
		  ($1) => String.fromCharCode(($1.charCodeAt(0) + key + 26 - 97) % 26 + 97)).replace(/([A-Z])/g, 
      ($1) => String.fromCharCode(($1.charCodeAt(0) + key + 26 - 65) % 26 + 65));
    
    this.encryption = result;
  }

  log(x) {
    console.log(x);
  }
}
