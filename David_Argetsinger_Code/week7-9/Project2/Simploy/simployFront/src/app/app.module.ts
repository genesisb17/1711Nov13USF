import { EditresumeComponent } from './editresume/editresume.component';
import { EditjobComponent } from './editjob/editjob.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatCheckboxModule, MatTableModule } from '@angular/material';

import { DataTablesModule } from 'angular-datatables';
import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router/';
import { ViewsinglejobComponent } from './viewsinglejob/viewsinglejob.component';
import { ViewsingleresumeComponent } from './viewsingleresume/viewsingleresume.component';
import { ViewjobsComponent } from './viewjobs/viewjobs.component';
import { ViewresumesComponent } from './viewresumes/viewresumes.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { SubmitjobComponent } from './submitjob/submitjob.component';
import { SubmitresumeComponent } from './submitresume/submitresume.component';
import { ProfileComponent } from './profile/profile.component';
import { SimployinfoComponent } from './simployinfo/simployinfo.component';
import { SkillsComponent } from './skills/skills.component';
import { ViewsubmittedjobsComponent } from './viewsubmittedjobs/viewsubmittedjobs.component';

const routes: Routes = [
  { path: '', component: SigninComponent},
  { path: 'navbar', component: NavbarComponent},
  { path: 'editjob', component: EditjobComponent},
  { path: 'editprofile', component: EditprofileComponent},
  { path: 'editresume', component: EditresumeComponent},
  { path: 'viewjobs', component: ViewjobsComponent},
  { path: 'viewsinglejob', component: ViewsinglejobComponent},
  { path: 'viewresumes', component: ViewresumesComponent},
  { path: 'viewsingleresume', component: ViewsingleresumeComponent},
  { path: 'submitjob', component: SubmitjobComponent},
  { path: 'submitresume', component: SubmitresumeComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'info', component: SimployinfoComponent},
  { path: 'skills', component: SkillsComponent},
  { path: 'viewsubmittedjobs', component: ViewsubmittedjobsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    ViewsinglejobComponent,
    ViewsingleresumeComponent,
    ViewjobsComponent,
    ViewresumesComponent,
    SubmitjobComponent,
    SubmitresumeComponent,
    ProfileComponent,
    EditjobComponent,
    EditresumeComponent,
    EditprofileComponent,
    SimployinfoComponent,
    SkillsComponent,
    ViewsubmittedjobsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    NgbModule.forRoot(),
    MatCheckboxModule,
    MatTableModule,
    DataTablesModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
