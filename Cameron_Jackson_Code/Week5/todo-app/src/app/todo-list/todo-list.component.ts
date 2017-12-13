import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  /* 
  We define todos as an input property within the @Inputt decorator.
  This allows us to inject todos from the parent component
  */
  @Input()
  todos: Todo[];

  /*
  Here we define two output events.
  */
  @Output()
  remove: EventEmitter<Todo> = new EventEmitter();

  @Output()
  toggleComplete: EventEmitter<Todo> = new EventEmitter();

  onRemoveTodo(todo: Todo) {
    this.remove.emit(todo);
  }

  onToggleTodoComplete(todo: Todo) {
    this.toggleComplete.emit(todo);
  }

  constructor() { }

  ngOnInit() {
  }

}
