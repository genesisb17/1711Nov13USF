import {Component} from '@angular/core';
import { CoursesService } from './course/courses.service';

@Component({
    //properties to tell Angular how the component works
    selector: 'courses', //uses css selectors ; with components we can extend HTML vocab. we're trying to define an element named 'courses'
    template: `
        <h2>{{ getTitle()}}</h2> 
        <ul>
            <li *ngFor="let course of courses">{{course}}</li> 
        </ul>` //html markup; string interpolation 
        // we use directives "ng-" to manipulate the dom
    //expressions are evaluated at runtime; data binding; we are binding our view with our component
})
export class CoursesComponent{
    title = "List of courses";
    courses;

    constructor(service: CoursesService){ //this constructor has a service dependency of type CoursesService
        this.courses = service.getCourses();
    }
   
}