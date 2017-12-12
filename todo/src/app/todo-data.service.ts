import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService 
{
  //placeholder for last id to simulate auto incrementing
  listId: number=0;
  todos:Todo[]=[];
  constructor() { }
  /*
  here we are starting our simulation of
  an api to do basic tasks for our to do list. The 
  following function will add the todo object
  (restricted to being of type Todo)
  and return the current instance of the TodoDataService.
  This is useful for many reasons, including the fact that it allows us
  to chain method calls from an instance of the service.
  */

  // simulating post /todos
  addTodo(todo:Todo):TodoDataService
  {
    if(!todo.id)
    {
      todo.id =++this.listId;
    }
    this.todos.push(todo);
    return this;
  }
  //stimulate DELETE /todos/:id
  deleteTodoById(id:number):TodoDataService
  {
    this.todos = this.todos.filter(todo => todo.id!==id);
    return this;
  }
  //simulate PUT /todos/:id;
  getTodoById(id:number):Todo
  {
    return this.todos.filter(todo=>todo.id===id).pop();
  }
  updateTodoById(id:number, values:{}):Todo
  {
    let todo = this.getTodoById(id);
    if(!todo) return null;
    Object.assign(todo,values);
    return todo;
  }
  //simulate get /todos
  getAllTodos():Todo[]
  {
    return this.todos;
  }
  toggleTodoComplete(todo:Todo)
  {
    let UpdatedTodo = this.updateTodoById(
      todo.id,{complete:!todo.complete});
      return UpdatedTodo;
  }
}