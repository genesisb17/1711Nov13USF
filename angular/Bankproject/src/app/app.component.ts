import { Component } from '@angular/core';
import {enableProdMode} from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  GotoUpdate()
  {
    enableProdMode();
    console.log("hooray");
  }
}
