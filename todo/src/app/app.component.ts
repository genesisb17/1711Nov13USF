import { Component } from '@angular/core';
import { TodoDataService } from './todo-data.service';
@Component({
  selector: 'app-root',
  //template: '<h2>hi, {{title}}</h2>',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[TodoDataService],

})
export class AppComponent 
{
  /*
  Ask DI system to inject the dependency associated with our DI
  token 'tododataservice' and assign it a property.
  */
  constructor(private todoDataService:TodoDataService)
  {
  }
}