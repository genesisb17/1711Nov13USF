import { Component,OnInit } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root', //if you're paying attention this is in index as a custom tag
  //template:`<h2> hi, {{name}} {{title}} </h2> hello `,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  
})
export class AppComponent implements OnInit {
  todos: Todo[] = [];
  /*
  ask depency injection ststem to inject dep associated
  with our DI token 'tododataservice' and assign a property

  */
  constructor(private apiService: ApiService) { }

  public ngOnInit() {
    this.apiService
      .getAllTodos()
      .subscribe((todos) => {
        this.todos = todos;
      })
  }
  
  /*
  ontoggleTodoComplete(todo: Todo){
    this.toDoDataService.toggleTodoComlete(todo);
  }
  onremoveTodo(todo: Todo){
    this.toDoDataService.deleteTodoById(todo.id);
  }

    get todos(){
    return this.toDoDataService.getAllTodos();
  }
  */
  onToggleTodoComplete(todo: Todo){
    todo.complete=!todo.complete;
    this.apiService.updateTodo(todo)
    .subscribe((newTodo)=>{
      todo=newTodo;
    });
  }
  onAddTodo(todo: Todo){
    this.apiService.createTodo(todo)
    .subscribe((newTodo) => {
      this.todos = this.todos.concat(newTodo);
    });
  }
  onremoveTodo(todo: Todo){
    this.apiService
    .deleteTodoById(todo.id)
    .subscribe(
      (_) => { //(_) is the same as ()
        this.todos = this.todos.filter((t) => t.id !== todo.id);
      }
    );
  }
}
