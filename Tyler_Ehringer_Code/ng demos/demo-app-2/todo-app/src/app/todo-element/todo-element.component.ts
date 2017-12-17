import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-element',
  templateUrl: './todo-element.component.html',
  styleUrls: ['./todo-element.component.css']
})
export class TodoElementComponent implements OnInit {

  @Output()
  complete: EventEmitter<Todo> = new EventEmitter();

  @Output()
  remove: EventEmitter<Todo> = new EventEmitter();
  
  @Input()
  todo: Todo;
    
  constructor() { }

  ngOnInit() {
  }

  toggleTodoComplete(todo) {
    this.complete.emit(todo);
  }

  removeTodo(todo) {
    this.remove.emit(todo);
  }
}
