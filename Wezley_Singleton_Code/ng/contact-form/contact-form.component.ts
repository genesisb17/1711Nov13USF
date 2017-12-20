import { Component } from '@angular/core';

@Component({
  selector: 'contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {

  contactMethods = [
    { id: 1, name: 'Email' },
    { id: 2, name: 'Phone' }
  ];

  log(x) { console.log(x); }

  submit(f) {
    //The 'value' object found in the ngForm object, is the user inputs
    //from the form group in JSON format
    console.log(f.value);
  }
}
