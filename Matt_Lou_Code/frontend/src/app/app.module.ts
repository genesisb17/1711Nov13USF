import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register.service';
import { UpdateService } from './update.service';
import { BalanceService } from './balance.service';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "landing", component: LandingComponent },
  { path: "register", component: RegisterComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LandingComponent,
    RegisterComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [LoginService, RegisterService, UpdateService, BalanceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
