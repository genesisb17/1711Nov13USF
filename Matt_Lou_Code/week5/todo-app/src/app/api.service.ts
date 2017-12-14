import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todo } from './todo';
import { Observable } from 'rxjs/Observable';

/*
  Observables are lazy collections of multiple values over time
*/

const API_URL = environment.apiUrl;
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  public getAllTodos(){
    return this.http.get<Todo[]>(API_URL+'/todos');

    }
    //GET todos/id
    public getTodoById(todoId: number){
      return this.http.get<Todo>(API_URL+'/todos/'+todoId);
    }
     // POST /todos
  public createTodo(todo: Todo){
        return this.http.post<Todo>(API_URL+'/todos', todo, httpOptions);
      }
      
      //PUT /todos/id
    public updateTodo(todo: Todo){
      return this.http.put<Todo>(API_URL+'/todos/'+todo.id, todo, httpOptions);
    }
      //DELETE /todos/id
      public deleteTodoById(todoId: number){
        this.http.delete(API_URL+'/todos/'+todoId);
      }
  }


