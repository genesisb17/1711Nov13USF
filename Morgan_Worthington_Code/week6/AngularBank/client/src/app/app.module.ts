import { DashboardComponent } from './dashboard/dashboard.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';

import {UserService} from './user.service';
import { AuthGuardGuard } from './auth-guard.guard';
import { RegisterComponent } from './register/register.component';

const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    canActivate: [AuthGuardGuard],
    component: DashboardComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    UserAccountComponent,
    LoginComponent,
    DashboardComponent,
    RegisterComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule
  ],
  providers: [UserService, AuthGuardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
