import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-list-footer',
  templateUrl: './todo-list-footer.component.html',
  styleUrls: ['./todo-list-footer.component.css']
})
export class TodoListFooterComponent implements OnInit {

  @Input()
  todos: Todo[];

  constructor() { }

  ngOnInit() {
  }

}
