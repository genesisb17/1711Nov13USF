import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  newTodo = new Todo();
  constructor(private tds: TodoDataService) {

  }

  toggleTodoComplete(todo: Todo) {
    this.tds.toggleTodoComplete(todo);
  }

  addTodo() {
    this.tds.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  get todos() {
    return this.tds.getAllTodos();
  }

  removeTodo(todo) {
    this.tds.deleteTodoById(todo.id);
  }

}
