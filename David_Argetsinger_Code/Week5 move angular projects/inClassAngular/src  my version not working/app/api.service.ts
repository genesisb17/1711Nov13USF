import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Todo } from './todo';
import { Observable } from 'rxjs/Observable';


//lazy collection of multiple values over time are obersvales 
// some kind of array.  streams 

//apiurl is an enviorment variables 
const API_URL = environment.apiUrl;
const httpOptions ={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable()
export class ApiService {


  constructor(private http: HttpClient) { }
  //get /todos
  public getAllTodos(){
   return  this.http.get<Todo[]>(API_URL+'\todos');
  }

  //post//tidis
  public createTodo(todo: Todo){

    return this.http.post<Todo[]>(API_URL+'/todos',todo, httpOptions );

  }
  //get /todis/id
  public getTodobyId(todoId: number){

    return this.http.get<Todo>(API_URL+'\todos'+todoId);

  }
  //put /todisu/id
  public updateTodo(todo: Todo){
    return this.http.put<Todo>(API_URL+'/todos/'+todo.id,todo,httpOptions);
  }
  //delete /todsu/id
  public deleteTodoById(todoId: number){
    return this.http.delete(API_URL+'/todos/'+todoId);
  }


}
