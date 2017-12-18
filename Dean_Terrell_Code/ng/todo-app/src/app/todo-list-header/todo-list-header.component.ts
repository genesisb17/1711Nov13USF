import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { Todo } from '../todo';

/* Instead of injecting our tododataservice into this component
to save the new Todo, we mite an add event and apss the new todo
as an argument
*/
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

  addTodo() {
    this.add.emit(this.newTodo);
    this.newTodo = new Todo();

  }

}
