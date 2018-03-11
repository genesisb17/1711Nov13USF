import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {GetDataService} from './get-data.service';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: 
  [
    HttpClientModule,
    BrowserModule
  ],
  providers: [GetDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
