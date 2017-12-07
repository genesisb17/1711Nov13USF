import {Component} from '@angular/core';
@Component({
    selector:'courses', // what to call html tags <courses>
  template: '<h2>{{ getTitle() }}</h2> <ul>  <li *ngFor="let course of courses"></li>  </ul> '  

})
export class CoursesComponent
{
    title = "List of courses";
    courses = ["course1","course2","course3"];
    getTitle()
    {
      return this.title;
    }
}