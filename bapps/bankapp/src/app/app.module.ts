import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { FormsModule } from '@angular/forms';
import { LginComponent } from './lgin/lgin.component';
import { RegisterComponent } from './register/register.component';
import { ViewComponent } from './view/view.component'
import { HttpModule } from '@angular/http/src/http_module';

@NgModule({
  declarations: [
    AppComponent,
    LginComponent,
    RegisterComponent,
    ViewComponent
  ],
  imports: 
  [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
