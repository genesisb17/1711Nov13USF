import { Todo } from './todo';
import { Injectable } from '@angular/core';

@Injectable()
export class TodoDataService {
  lastId: any;

  todos: Todo[] = [];

  constructor() { }

  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastId;
    }

    this.todos.push(todo);
    return this;
  }

  deleteTodoById(id:number): TodoDataService{
    
    this.todos = this.todos.filter(todo => todo.id !== id);

    return this;
  }

  getTodoById(id: number): Todo {
    return this.todos.filter(todo => todo.id === id).pop();
  }

  updateTodoById(id: number, values: {}): Todo {
    let todo = this.getTodoById(id);
    if(!todo) return null;
    Object.assign(todo, values);
    return todo;
  } 

  getAllTodos(): Todo[] {
    return this.todos;
  }

  toggleTodoComplete(todo: Todo) {
    let updatedTodo = this.updateTodoById(
      todo.id, {complete: !todo.complete}
    );
    return updatedTodo;
  }


}


