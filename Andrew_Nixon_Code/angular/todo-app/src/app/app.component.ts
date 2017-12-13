import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
 // template:'<h2>hi, {{name}}<h2>',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  /*
    ask DI system to inject the depency associated with DI token 
    todoDS
  */
  newTodo: Todo = new Todo();
  constructor(private todoDS: TodoDataService){}

  togTodoDone(todo){
    this.todoDS.toggleTodoComplete(todo);
  }

  addTodo(){
    this.todoDS.addTodo(this.newTodo);
    this.newTodo = new Todo();
  }

  get todos(){
    return this.todoDS.getAllTodos();
  }

}
