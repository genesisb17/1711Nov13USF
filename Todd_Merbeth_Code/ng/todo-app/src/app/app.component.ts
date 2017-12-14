import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';
import { ApiService } from './api.service';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  // template: '<h2> hi, {{title}} </hi>', // can use in line HTML or an HTML file
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [TodoDataService]      // Don't need this now, providers are availiable to be injected
})
export class AppComponent implements OnInit {
  // newTodo: Todo = new Todo();
  todos: Todo[] = [];
  // get todos(){
  //   return this.apiService.getAllTodos();
  // }

  /*     DI = Dependecy Injection
    Ask DI system to inject the dependency associated 
    with our DI token 'todataservice' and assign it a property.
  */
  // constructor(private todoDataService: TodoDataService) { }
  constructor(private apiService: ApiService) { }

  // toggleTodoComplete(todo){
  //   this.todoDataSevice.toggleTodoComplete(todo);
  // }
  // addTodo(){
  //   this.todoDataSevice.addTodo(this.newTodo);
  //   this.newTodo = new Todo();
  // }

  ngOnInit() {
    this.apiService.getAllTodos().subscribe((todos) => { this.todos = todos; });
  }
  onAddTodo(todo: Todo) {
    this.apiService.createTodo(todo).subscribe((newTodo) => { this.todos = this.todos.concat(newTodo); });
  }
  onRemoveTodo(todo: Todo) {
    this.apiService.deleteTodoById(todo.id).subscribe((_) => { this.todos = this.todos.filter((t) => t.id !== todo.id);});
  }
  onToggleTodoComplete(todo: Todo) {
    todo.complete = !todo.complete;
    this.apiService.updateTodo(todo).subscribe((newTodo) => { todo = newTodo; });
  }

  // onAddTodo(todo: Todo){
  //   this.todoDataSevice.addTodo(todo);
  // }

  // get todos(){
  //   return this.todoDataSevice.getAllTodos();
  // }

  // onToggleTodoComplete(todo){
  //   this.todoDataSevice.toggleTodoComplete(todo);
  // }

  // onRemoveTodo(todo){
  //   this.todoDataSevice.deleteTodoById(todo.id);
  // }
}

