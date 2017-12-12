import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {
  //placeholder for last id to simulate auto incrementing
  lastId: number = 0;

  todos: Todo[] = [];
  constructor() { }

  /* Here we are starting our simulation of an api to do
  basic taskss for our to do list. The following function will 
  add the todo object ( restricted to being of type Todo) and 
  return the current instance of the TodoDataService. This is
  useful for many reasons, including that it allows us to
  chain method calls fro an instance of the service
  */

  // simulating POST /todos
  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    return this;
  }

  // simulate DELETE /todos/:id
  deleteTodoById(id: number): TodoDataService{
    this.todos = this.todos.filter(todo => todo.id !==id)
    return this;
  }

  //simulate Get /todos/:id
  getTodoById(id: number): Todo {
    return this.todos.filter(todo =>todo.id === id).pop();
  }

  //simulate PUT /todos/:id
  updateTodoById(id: number, values: {}): Todo{
    let todo = this.getTodoById(id);
    if(!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  //simulate Get /todos
  getAllTodos(): Todo[] {
    return this.todos;
  }

  toggleTodoComplete(todo: Todo) {
    let updatedTodo = this.updateTodoById(
      todo.id, {complete: !todo.complete});
    return updatedTodo;
  }
}
