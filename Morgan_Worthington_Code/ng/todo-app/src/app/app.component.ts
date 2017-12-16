import { ApiService } from './api.service';
import { Component } from '@angular/core';
import {TodoDataService} from './todo-data.service';
import {Todo} from './todo';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-root',
  //template: `<h2> hi, {{name}} {{title}} </h2>` ,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  /*
    Ask DI (dependency injection) system to inject the dependency associated 
    with our DI token 'tododataservice' and assign it a property.

  */
  //constructor(private todoDataService: todoDataService)
  constructor(private apiService: ApiService){}

  get todos(){
    return this.apiService
    .getAllTodos();
  }

  public ngOnInit(){
    this.apiService
      .getAllTodos()
      .subscribe((todos)=>{
        this.todos=todos;
      })
  }

  onAddTodo(todo:Todo){
    this.apiService.createTodo(todo)
    .subscribe((newTodo)=> {
      this.todos=this.todos.concat(newTodo);
    });
  }

//   onAddTodo(todo:Todo){
//     this.todoDataService.addTodo(todo);
//   }

//   get Todos(){
//     return this.todoDataService.getAllTodos();
//   }

// toggleTodoComplete(todo){
//   this.todoDataService.toggleTodoComplete(todo);
// }

// removeTodo(todo){
//   this.todoDataService.deleteTodoById(todo.id);
// }
}
