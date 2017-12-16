import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PasswordComponent } from './password.component';

@NgModule({
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    PasswordComponent
  ],
  declarations: [PasswordComponent]
})
export class PasswordModule { }
