import { Todo } from './todo';
import { environment } from './../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

/*
  Observables are lazy collections of multiple values over time/"streams"

*/

//API_URL - stored as an environment var = localhost:3000
const API_URL=environment.apiURL;
const httpOptions={
  headers: new HttpHeaders({'Content-Type':'application/json'})
};
@Injectable()
export class ApiService {



  constructor(private http: HttpClient) { }
  
  //GET /todos
  public getAllTodos(){
    return this.http.get<Todo[]>(API_URL+'/todos');

    
  }

  //POST /todos
  public createTodo(todo: Todo){
    return this.http.post<Todo>(API_URL+'/todos', todo, httpOptions);
  }

  //GET todos/id
  public getTodoById(todoId: number){
    return this.http.get<Todo>(API_URL+'/todos/'+todoId);
  }

  //PUT /todos/id
  public updateTodo(todo: Todo){
    return this.http.put<Todo>(API_URL+'/todos/'+todo.id,todo,httpOptions);
  }

  //DELETE /todos/id
  public deleteTodoById(todoId: number){
    return this.http.delete(API_URL+'/todos/'+todoId);
  }
}
