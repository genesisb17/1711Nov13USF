import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
 // template: `<h2> hi, {{ name }}
  // {{title}} </h2>` ,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  name = "gen";
}
