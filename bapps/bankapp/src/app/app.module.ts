import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LginComponent } from './lgin/lgin.component';
import { RegisterComponent } from './register/register.component';
import { ViewComponent } from './view/view.component'

@NgModule({
  declarations: [
    AppComponent,
    LginComponent,
    RegisterComponent,
    ViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
