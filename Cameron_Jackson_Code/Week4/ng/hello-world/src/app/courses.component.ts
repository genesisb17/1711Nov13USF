import { Component } from '@angular/core';
import { CoursesService } from './courses.service';

@Component({
    selector: 'courses', // basic css selector. referencing <courses> element
    template: `
        <h2>{{ title }}</h2>
        <ul>
            <li *ngFor="let course of courses">
                {{ course }}
            </li>
        </ul>
        `
})
export class CoursesComponent {
    title = "List of courses";
    courses;

    // Logic for calling an HTTP service (tightly coupled, potentially more difficult for testing)
    // This is dependency injection: Dependecies needed for this service are passed as parameter to constructor
    constructor(service: CoursesService) { 
        this.courses = service.getCourses();
    }
}