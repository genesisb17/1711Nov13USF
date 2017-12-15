import { Component, OnInit } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 
  todos: Todo[] = [];
  /*
    Ask DI system to inject the dependency associated 
    with our DI token 'tododataservice' and assign it a property.
  */
  //constructor(private todoDataService: TodoDataService){}

  constructor(private apiService: ApiService) { }

  export class AppComponent{
    
  }


  /* ABOVE IS PASSWORD COMPONENET FOR EXAMPLE
***********************************************************************
  */

  public ngOnInit() {
    this.apiService
      .getAllTodos()
      .subscribe((todos) => {
        this.todos = todos;
      })
  }

  onAddTodo(todo: Todo) {
    this.apiService.createTodo(todo)
      .subscribe((newTodo) => {
        this.todos = this.todos.concat(newTodo);
      });
  }



  onRemoveTodo(todo) {
    this.apiService
      .deleteTodoById(todo.id)
      .subscribe(
        (_) => { //(_) is the same as ()
          this.todos = this.todos.filter((t) => t.id !== todo.id);
        }
      );
  }

  onToggleTodoComplete(todo: Todo) {
    todo.complete = !todo.complete;
    this.apiService.updateTodo(todo)
      .subscribe((newTodo) => {
        todo = newTodo;
      });
  }


  // onAddTodo(todo: Todo){
  //   this.todoDataService.addTodo(todo);
  // }

  // get todos(){
  //   return this.todoDataService.getAllTodos();
  // }

  // onToggleTodoComplete(todo: Todo){
  //   this.todoDataService.toggleTodoComplete(todo);
  // }

  // onRemoveTodo(todo: Todo){
  //   this.todoDataService.deleteTodoById(todo.id);
  // }

}
