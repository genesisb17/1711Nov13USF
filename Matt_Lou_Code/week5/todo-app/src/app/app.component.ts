import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
 // template: '<h2> {{ name }} </h2>',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  newTodo: Todo = new Todo();
  
  /*
    DI = Dependency Injection
    Ask DI system to inject the dependency associated with our DI toekn
    'tododataservice' and assign it a property.
  */
  constructor(private todoDataService: TodoDataService) {}

  // toggleTodoComplete(todo) {
  //   this.todoDataService.toggleTodoComplete(todo);
  // }
  addTodo(){
    this.todoDataService.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  onAddTodo(){
    this.todoDataService.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  get todos(){
    return this.todoDataService.getAllTodos();
  }

  onToggleTodoComplete(todo: Todo){
    this.todoDataService.toggleTodoComplete(todo);
  }

  onRemoveTodo(todo: Todo){
    this.todoDataService.deleteTodoById(todo.id);
  }

}
