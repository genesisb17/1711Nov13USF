import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable()
export class TodoDataService {
  //placeholder for last id for auto increment id numbers 
  lastId: number = 0;
  todos: Todo[] = [];
  

  constructor() { }
  //we start out simulation of api todo basic tasks for list 
  // following function will add the todo object (restricted to being type Todo)
  //and return the current instance of the TodoDataService  , we do this 
  // to chain methods calls from an instance 

  //simulating POST /todos 
  addTodo(todo: Todo): TodoDataService{
    if(!todo.id){
      todo.id = ++this.lastId;
    }
    this.todos.push(todo);
    return this;
  }

  //simulate DELTE /todos/:id if viod just return this 
  // allows for chaining  doesn't change anything 
  // just allows for extra functionality 
  deleteTodoById(id:number):TodoDataService{
    //filder doesn't delete, but assigned new array without that element 
    this.todos=this.todos.filter(todo=>todo.id!==id);
    return this;
  }

  //simulate get /todos/:id
  getTodoById(id: number):Todo{
    return this.todos.filter(todo=>todo.id==id).pop();
    //could also be todo[0] you're making a new list with JUST the id you're looking for 
    // pop retuns the single one ; 
  }



  //simulate PUT /todos/:id 
  // {} is for object sent in 
  updateTodoById(id:number,values:{}):Todo{
    let todo=this.getTodoById(id);
    if(!todo)return null;
    //if todo doesn't exist return null 
    Object.assign(todo,values);
    return todo;
  }

  //simulate GET /todos 
  getAllTodos():Todo[]{

    return this.todos;
  }


  //return type is optionl, can specify any is a keyword m8  
  toggleTodoComlete(todo:Todo){
    let updatedTodo= this.updateTodoById(
      todo.id,{complete: !todo.complete}
    );
    return updatedTodo;
  }
  // hwere we do new concepts as arrow notation filters 
  //specifiing return types  (annotated), we have centralized our biz logic in the service
  //
}
