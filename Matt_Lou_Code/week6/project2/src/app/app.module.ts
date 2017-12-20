import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { FacebookComponent } from './facebook/facebook.component';
import { FbcredentialsComponent } from './fbcredentials/fbcredentials.component';


@NgModule({
  declarations: [
    AppComponent,
    FacebookComponent,
    FbcredentialsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
