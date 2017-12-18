import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PasswordComponent } from './password.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [PasswordComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [PasswordComponent]
})
export class PasswordModule { }
