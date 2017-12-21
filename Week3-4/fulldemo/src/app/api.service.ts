import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';

import { Http, Response } from '@angular/http';
import { Todo } from './todo';
import { Observable } from 'rxjs/Observable';

const API_URL = environment.apiUrl;

@Injectable()
export class ApiService {

  constructor(private http: Http) {}

}
