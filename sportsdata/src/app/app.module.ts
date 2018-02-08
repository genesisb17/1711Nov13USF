import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {SportsserviceService}from './sportsservice.service';
import { AppComponent } from './app.component';
import { SportsapistatsComponent } from './sportsapistats/sportsapistats.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    SportsapistatsComponent
  ],
  imports: [
    BrowserModule,HttpClientModule
  ],
  providers: [SportsserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
