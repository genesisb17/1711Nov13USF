import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {
  //placeholder for last id to simulate auto incrementing
  lastId: number = 0;

  todos: Todo[] = [];
  
  constructor() { }

  /* Here we are starting our simulation of an api to do
    basic tasks for our to do list. The following functions will
    add the todo object (restricted to being of type Tedo) and
    return the current intance of the TodoDataService. This is
    useful for many reasons, including the fact that it allows us
    to chain method calls from an instance of the service.
  */

  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    return this;
  }

  //simulate DELETE /todos/:id
  deleteTodoById(id:number): TodoDataService{
    this.todos = this.todos.filter(todo => todo.id !==id);
    return this;
  }

  //simulate GET /todos/:id
  getTodoById(id: number): Todo{
    return this.todos.filter(todo=>todo.id === id).pop();
  }

  //simulate PUT /todos:id
  updateTodoById(id:number, values: Object = {}): Todo{
    let todo = this.getTodoById(id);
    if(!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  getAllTodos(): Todo[]{
    return this.todos;
  }

  toggleTodoComplete(todo: Todo){
    let updatedTodo = this.updateTodoById(
      todo.id , {complete: !todo.complete});
      return updatedTodo;
  }
}

/*
Here we do introduce some new concepts in terms of
arrow notation, filters, specified return types, etc

HOWEVER: the main takeaway is that we have centralized
our biz logic (didnt finish these notes in time)
*/
