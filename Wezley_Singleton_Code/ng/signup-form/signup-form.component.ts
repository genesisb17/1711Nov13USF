import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UsernameValidators } from './username.validators';

@Component({
  selector: 'signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent {
  // to assign multiple validators to a FormControl, simply
  // pass an array of Validator functions to the FormControl object
  form = new FormGroup({
    account: new FormGroup({
      'username': new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        UsernameValidators.cannotContainSpace], 
        UsernameValidators.shouldBeUnique),
      'password': new FormControl('', Validators.required)
    })
  });

  login() {
    this.form.setErrors({
      invalidLogin: true
    });
  }

  // this property helps to clean up the template code
  get username() {
    return this.form.get('account.username');
  }

  // this property helps to clean up the template code
  get password() {
    return this.form.get('password');
  }

}
