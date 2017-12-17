import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


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
import { CreateReimbursementComponent } from './create-reimbursement/create-reimbursement.component';
import { AuthenticationService } from './authentication.service';
import { UpdateReimbursementComponent } from './update-reimbursement/update-reimbursement.component';
import { ProfileComponent } from './profile/profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';

const appRoutes: Routes = [
  { path: "landing", component: LandingComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "reimbursements", component: ReimbursementsComponent, canActivate: [AuthenticationService] },
  { path: "home", component: UserinfoComponent, canActivate: [AuthenticationService] },
  { path: "updateUser", component: ProfileComponent, canActivate: [AuthenticationService] },
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
    ReimbursementComponent,
    CreateReimbursementComponent,
    UpdateReimbursementComponent,
    ProfileComponent,
    ChangePasswordComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { enableTracing: false }),
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [
    AccountService,
    ReimbursementService,
    AuthenticationService
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    LoginComponent,
    CreateReimbursementComponent,
    UpdateReimbursementComponent,
    ChangePasswordComponent
  ]
})
export class AppModule { }
