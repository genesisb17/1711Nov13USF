import { FormsModule } from '@angular/forms';
import { TodoDataService } from './todo-data.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TodoListHeaderComponent } from './todo-list-header/todo-list-header.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoListFooterComponent } from './todo-list-footer/todo-list-footer.component';
import { ApiService } from './api.service';
import { HttpClientModule } from '@angular/common/http/';
//need to do a variety of imports, compare with documents on git

@NgModule({
  declarations: [
    AppComponent,
    TodoListHeaderComponent,
    TodoListComponent,
    TodoListFooterComponent
  ],
  imports: [
    BrowserModule,FormsModule, HttpClientModule
  ],
  providers: [TodoDataService, ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
