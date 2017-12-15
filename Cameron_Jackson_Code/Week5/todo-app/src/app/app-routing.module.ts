import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { TodosComponent } from './todos/todos.component';

const routes: Routes = [
  {
    path:'', redirectTo: 'todos', pathMatch: 'full'
  },
  {
    path:'todos', component: TodosComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
