import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component'
import { RouterModule, Routes} from '@angular/router';
import { UserService } from './user.service';
import { RegisterComponent } from './register/register.component';

const routes: Routes=[
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'logged',
    component: LandingComponent
  }, 
  {
    path: 'register',
    component: RegisterComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LandingComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(routes)
  ],
  providers: [LoginService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
