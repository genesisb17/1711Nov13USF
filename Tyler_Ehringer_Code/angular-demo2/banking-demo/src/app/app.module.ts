import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginService } from './login.service';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LginComponent } from './lgin/lgin.component';
import { LandingComponent } from './landing/landing.component';
import { RouterModule, Routes } from '@angular/router'

const routes: Routes=[
  { path: "", component: LginComponent },
  { path: "landing", component: LandingComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LginComponent,
    LandingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
