import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {

  lastId: number = 0;
  todos: Todo[] = [];

  constructor() { }

  /* 
    Here we are starting our simulation of an api to do 
    basic tasks for our to-do list. The following function will add the todo object
    and will return the current instance of the TodoDataService. This is useful
    for things like chaining method calls from an instance of the service
  */
  // simulating POST /todos
  addTodo(todo: Todo): TodoDataService {
    if (!todo.id) {
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    return this;
  }

  // simulating DELETE /todos/:id
  deleteTodo(todo: Todo | number): TodoDataService {
    const id = typeof todo === 'number' ? todo : todo.id;

    this.todos = this.todos.filter(todo => todo.id !== id);
    return this;
  }

  // simulate GET /todos/:id
  getTodoById(id: number): Todo {
    return this.todos.filter(todo => todo.id === id).pop();
  }

  // simulate PUT /todos/:id
  updateTodoById(id: number, values: Object) {
    let todo = this.getTodoById(id);
    if (!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  // simulate GET /todos
  getAllTodos(): Todo[] {
    return this.todos;
  }

  toggleTodoComplete(todo: Todo): Todo {
    let updatedTodo = this.updateTodoById(
      todo.id, {complete: !todo.complete}
    )
    return updatedTodo;
  }
}
