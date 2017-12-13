import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {TodoDataService} from './todo-data.service';
import { TodoListHeaderComponent } from './todo-list-header/todo-list-header.component'

@NgModule({
  declarations: [
    AppComponent,
    TodoListHeaderComponent
  ],
  imports: [
    BrowserModule
  ],
  providers:[TodoDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
