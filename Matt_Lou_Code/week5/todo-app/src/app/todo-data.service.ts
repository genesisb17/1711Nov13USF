import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {
  
  //placeholder for last id to simulate auto increment
  lastId: number = 0;

  todos: Todo[] = [];

  constructor() { }

  /*
    The following function will add the todo object
    (restricted to being of type Todo) and return the current instance of the 
    toDoDataService. This allows us to chain method calls from an instance
    of the service
  */

  // simulate POST/todos
  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    return this;
  }

  // simulate DELETE /todos/:id
  deleteTodoById(id: number): TodoDataService{
    this.todos = this.todos.filter(todo => todo.id !== id);

    return this;
  }

  // simulate GET/todos/:id
  getTodoById(id: number): Todo{
    return this.todos.filter(todo => todo.id === id).pop();
  }

  // simulate PUT/todos/:id; put should 'update'
  updateTodoById(id: number, values: {}): Todo{
    let todo = this.getTodoById(id);
    if(!todo) return null;
    Object.assign(todo, values);
    return todo;
  }

  getAllTodos(): Todo[]{
    return this.todos;
  }

  toggleTodoComplete(todo: Todo) {
    let updatedToDo = this.updateTodoById(
      todo.id , {complete: !todo.complete});
      return updatedToDo;
  }

}

/*
  new concepts: arrow notation, filters, specified return types, etc.
  main takeaway: centralized businesss logic
*/
