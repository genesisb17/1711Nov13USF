import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todo } from './todo';
import { Observable } from 'rxjs/Observable';
// lazy collections of multiple values over time
// * cancellable

const API_URL = environment.apiUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  // GET /todos
  public getAllTodos() {
    return this.http.get<Todo[]>(API_URL+'/todos');
  }

  // POST /todos
  public createTodo(todo: Todo) {
    return this.http.post<Todo>(API_URL+'/todos', todo, httpOptions);
  } 

  // GET /todos/id
  public getTodo(todo: Todo | number) {
    const id = typeof todo === 'number' ? todo : todo.id; 
    return this.http.get<Todo>(API_URL+'/todos/'+id);
  }

  // PUT /todos/id
  public updateTodo(todo: Todo | number) {
    const id = typeof todo === 'number' ? todo : todo.id;
    return this.http.put<Todo>(API_URL+'/todos/'+id, todo, httpOptions);
  }

  //DELETE /todos/id
  public deleteTodo(todo: Todo | number) {
    const id = typeof todo === 'number' ? todo : todo.id;
    return this.http.delete<Todo>(API_URL+'/todos');
  }
}
