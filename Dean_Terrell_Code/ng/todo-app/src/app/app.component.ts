import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  
  todos: Todo[] = [];

  constructor(private apiService: ApiService) {}

  public ngOnInit() {
    this.apiService.getAllTodos().subscribe((todos) => {this.todos = todos;});
  }

  onAddTodo(todo: Todo) {
    this.apiService.createTodo(todo).subscribe((newTodo) => {this.todos = this.todos.concat(newTodo);});
  }
  onRemoveTodo(todo: Todo) {
    this.apiService.deleteTodoById(todo.id).subscribe(
      (_) => {
        this.todos = this.todos.filter((t) => t.id !== todo.id);
      }
    );
  }

  onToggleTodoComplete(todo: Todo) {
    todo.complete = !todo.complete;
    this.apiService.updateTodo(todo).subscribe((newTodo) => {todo = newTodo;});
  }

}
