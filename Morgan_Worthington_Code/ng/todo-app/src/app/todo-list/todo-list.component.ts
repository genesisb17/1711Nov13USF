import { Todo } from './../todo';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
/*We define todos as an input property with the @Input decorator. This allows us
  to inject todos from the parent component.
*/
@Input()
todos: Todo[];

/*
  Here we define two output events. We set their type to EventEmitter<Todo> and 
  assign them a new eventemitter instance. this is a generic type that tells TS that
  both remove and toggleComplete are event emitter instances and taht the values they
  emit are todo instances.
*/
@Output()
remove: EventEmitter<Todo> = new EventEmitter();

@Output()
toggleComplete: EventEmitter<Todo> = new EventEmitter();

onRemoveTodo(todo: Todo){
  this.todoDataService.deleteTodoById(todo.id);
}

onToggleTodoComplete(todo: Todo){
  this.todoDataService.toggletodoComplete(todo);
}

constructor() { }

ngOnInit() {
}



}
