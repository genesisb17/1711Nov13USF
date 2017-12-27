import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class ChuckNorrisService {
  private jokeCache = new BehaviorSubject<any>([undefined]);
  jokeData$ = this.jokeCache.asObservable();

  constructor(private http: Http) {
    this.fetch();
  }

  fetch() {
    this.http.get('http://api.icndb.com/jokes/random').subscribe(
      succ => this.jokeCache.next(succ.json())
    );
  }
}
