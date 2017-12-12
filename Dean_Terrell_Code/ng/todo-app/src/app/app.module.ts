import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TodoDataService } from './todo-data.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, FormsModule 
  ],
  providers: [TodoDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
