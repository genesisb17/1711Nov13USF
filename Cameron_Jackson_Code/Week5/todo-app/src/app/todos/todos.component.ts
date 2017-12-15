import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {
  todos: Todo[] = [];
  /*
    Ask DI system to inject the dependency associated with our
    DI token 'todoDataService' and assign it a property.
  */ 
  constructor(private apiService: ApiService){}

  public ngOnInit() {
    this.apiService.getAllTodos()
      .subscribe((todos) => {
        this.todos = todos;
      });
  }
  // addTodo() {
  //   this.todoDataService.addTodo(this.newTodo);
  //   this.newTodo = new Todo();
  // }

  onAddTodo(todo: Todo) {
    this.apiService.createTodo(todo)
      .subscribe((newTodo) => {
        this.todos = this.todos.concat(newTodo);
      });
  }

  onRemoveTodo(todo: Todo) {
    this.apiService.deleteTodo(todo)
      .subscribe((_) => {
        this.todos = this.todos.filter((t) => t.id !== todo.id);
      });

    this.apiService.getAllTodos()
      .subscribe((todos) => {
        this.todos = todos;
      });
  }

  onToggleTodoComplete(todo: Todo) {
    todo.complete = !todo.complete;
    this.apiService.updateTodo(todo)
      .subscribe((newTodo) => {
        todo = newTodo;
      });
  }

  // get todos() {
  //   return this.todoDataService.getAllTodos();
  // }

  // onToggleTodoComplete(todo: Todo) {
  //   this.todoDataService.toggleTodoComplete(todo);
  // }

  // onRemoveTodo(todo: Todo) {
  //   this.todoDataService.deleteTodo(todo);
  // }
}
