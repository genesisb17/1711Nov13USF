import { Component, OnInit, OnDestroy, Inject } from '@angular/core';
import {FlashcardService} from '../../services/flashcard.service';
import { Subscription } from 'rxjs/Rx';
import { ChuckNorrisService } from '../../services/chuck-norris.service';

@Component({
  selector: 'app-http-cached',
  templateUrl: './http-cached.component.html',
})
export class HttpCachedComponent implements OnInit, OnDestroy {

  public jokeObserver: Subscription;
  public joke: any;

  constructor(private jokeService: ChuckNorrisService) {

  }

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.jokeObserver = this.jokeService.jokeData$.subscribe(
      data => this.joke = data
    );

  }

  newData() {
    this.jokeService.fetch();
  }

  ngOnDestroy() {
    this.jokeObserver.unsubscribe();
  }
}
