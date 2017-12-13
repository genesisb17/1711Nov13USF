import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {
  //placeholder for last id used
  lastID: number = 0;
  todos: Todo[] = [];
  constructor() { }

  /*
  here we are starting our simulation for our api.
  */

  //simulating POST /todos
  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastID;
    }
    this.todos.push(todo);
    return this;
  }

  //simulate DELETE /todos/:id
  deleteTodoByID(id: number): TodoDataService{
    this.todos = this.todos.filter(todo => todo.id !==id);
    return this;
  }

  //sim GET /todos/:id
  getTodoByID(id: number): Todo{
    return this.todos.filter(todo=>todo.id === id).pop();
  }

  //simulate PUT /todos/:id
  updateTodoByID(id: number, values: {}): Todo{
    let todo = this.getTodoByID(id);
    if(!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  //sim GET /todos
  getAllTodos(): Todo[]{
    return this.todos;
  }

toggleTodoComplete(todo: Todo){
  let updatedTodo = this.updateTodoByID(
    todo.id, {complete: !todo.complete}
  );
  return updatedTodo;
  //if(todo.done) todo.done = false
  //else todo.done = true;
}

}
