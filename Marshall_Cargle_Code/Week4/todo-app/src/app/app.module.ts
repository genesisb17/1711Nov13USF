import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'


import { AppComponent } from './app.component';
import {TodoDataService} from './todo-data.service';
import { TodoListHeaderComponent } from './todo-list-header/todo-list-header.component';


@NgModule({
  declarations: [
    AppComponent,
    TodoListHeaderComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [TodoDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
