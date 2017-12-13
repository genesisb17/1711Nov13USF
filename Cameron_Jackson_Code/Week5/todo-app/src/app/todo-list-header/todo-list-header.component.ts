import { Component, Output } from '@angular/core';
import { Todo } from '../todo';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-todo-list-header',
  templateUrl: './todo-list-header.component.html',
  styleUrls: ['./todo-list-header.component.css']
})
export class TodoListHeaderComponent {

  newTodo: Todo = new Todo();

  @Output()
  add: EventEmitter<Todo> = new EventEmitter();

  constructor() { }

  /* 
    Instead of injecting out tododataservice into this component
    to save the new Todo, we emit an add event and pass the new todo
    as an argument
  */
  addTodo() {
    this.add.emit(this.newTodo);
    this.newTodo = new Todo();
  }
}
