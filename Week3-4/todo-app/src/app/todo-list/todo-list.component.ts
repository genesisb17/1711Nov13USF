import { Component, OnInit , Input, Output, EventEmitter} from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  /* we define todos as an input property with the @Input
    decorator. This allows us to inject todos from the
    parent component      */
  @Input()
  todos: Todo[];

  /*HEre we define two output events. We set their type to 
  EventEmitter<Todo> and assign them a new eventemitter instance
  this is a generic type that tells TS that both remove
  and togglecomplete are event emitter instances and that the 
  values they emit are todo instances*/ 
  @Output()
  remove: EventEmitter<Todo> = new EventEmitter();

  @Output()
  toggleComplete: EventEmitter<Todo> = new EventEmitter();

  removeTodo(todo: Todo){
    this.remove.emit(todo);
  }

  toggleTodoComplete(todo: Todo){
    this.toggleComplete.emit(todo);
  }

  constructor() { }

  ngOnInit() {
  }



}
