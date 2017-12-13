import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router'


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AccountService } from './account.service';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { RegisterComponent } from './register/register.component';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { ReimbursementService } from './reimbursement.service';
import { ReimbursementsComponent } from './reimbursements/reimbursements.component';
import { ReimbursementComponent } from './reimbursement/reimbursement.component';

const appRoutes: Routes = [
  { path: "landing", component: LandingComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "home", component: UserinfoComponent },
  { path: "", redirectTo: "/landing", pathMatch: "full" },
  //{ path: "**", component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    LandingComponent,
    RegisterComponent,
    UserinfoComponent,
    ReimbursementsComponent,
    ReimbursementComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { enableTracing: false })
  ],
  providers: [AccountService, ReimbursementService],
  bootstrap: [AppComponent]
})
export class AppModule { }
