import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.prod';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Todo } from './todo';
import { Observable } from 'rxjs/Observable'

const API_URL = environment.apiUrl;

const OPTIONS = {
  headers: new HttpHeaders({ 'content-type': "application/json" })
};

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  public getAllTodos() {
    return this.http.get<Todo[]>(API_URL + "/todos");
  }

  public createTodo(todo: Todo) {
    return this.http.post<Todo>(API_URL + "/todos", todo, OPTIONS);
  }

  public getTodo(id: number) {
    return this.http.get<Todo>(API_URL + "/todos/" + id);
  }

  public updateTodo(todo: Todo) {
    return this.http.put<Todo>(API_URL + "/todos/" + todo.id, todo, OPTIONS);
  }

  public deleteTodo(id: number) {
    return this.http.delete(API_URL + "/todos/" + id);
  }

}
