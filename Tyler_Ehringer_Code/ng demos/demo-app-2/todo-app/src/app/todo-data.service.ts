import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {

  lastId: number = 0;
  todos: Todo[] = [];

  constructor() { }

  addTodo(todo: Todo): TodoDataService {
    if (!todo.id) {
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    this.lastId = todo.id;
    return this;
  }

  deleteTodoById(id: number): TodoDataService{
    this.todos = this.todos.filter(a => a.id != id);
    return this;
  }

  getToDoById(id: number): Todo{
    return this.todos.filter(a => a.id == id).pop();
  }

  updateTodoById(id: number, values: {}): Todo{
    let todo = this.getToDoById(id);
    if (!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  getAllTodos() {
    return this.todos;
  }

  toggleTodoComplete(todo: Todo) {
    let updatedTodo = this.updateTodoById(todo.id, { complete: !todo.complete });
    return updatedTodo;
  }

}
