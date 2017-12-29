import { Component, OnInit, Input,Output,EventEmitter } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  /*we deine todos as an imput property with the @input 
  decorator this allows us to inject todos from the parent
  component 
  */
  @Input()
  todos:Todo[];
  /* here we devfine two output events we set their tyime to EventEmitter<todo> and siign them 
  a new eventemitter instance this is a genric type that tells TS that both remove and togglecomplete 
  are event emitter instacnes  */
  @Output()
  remove: EventEmitter<Todo> = new EventEmitter();
  @Output()
  toggleComplete: EventEmitter<Todo>= new EventEmitter();

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
