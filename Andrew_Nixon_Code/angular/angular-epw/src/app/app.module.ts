import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { PasswordComponent } from './password/password.component';
import { Pass2Module } from './pass2/pass2.module';


@NgModule({
  declarations: [
    AppComponent,
    PasswordComponent
  ],
  imports: [
    BrowserModule,
    Pass2Module
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
