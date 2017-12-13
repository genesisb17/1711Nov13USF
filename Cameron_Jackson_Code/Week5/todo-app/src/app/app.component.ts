import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  newTodo: Todo = new Todo();
  /*
    Ask DI system to inject the dependency associated with our
    DI token 'todoDataService' and assign it a property.
  */ 
  constructor(private todoDataService: TodoDataService){}

  addTodo() {
    this.todoDataService.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  onAddTodo(todo: Todo) {
    this.todoDataService.addTodo(todo);
  }

  get todos() {
    return this.todoDataService.getAllTodos();
  }

  onToggleTodoComplete(todo: Todo) {
    this.todoDataService.toggleTodoComplete(todo);
  }

  onRemoveTodo(todo: Todo) {
    this.todoDataService.deleteTodo(todo);
  }
}
