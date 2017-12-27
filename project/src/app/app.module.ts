import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {HttpModule} from '@angular/http';
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations:
  [
    AppComponent
  ],
  imports: 
  [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
