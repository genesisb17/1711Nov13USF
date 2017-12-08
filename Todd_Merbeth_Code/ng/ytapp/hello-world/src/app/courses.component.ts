import {Component} from '@angular/core';
import { CoursesService } from './courses.service';

@Component({
    selector: 'courses',
    template: `
        <h2>{{ title }}</h2>
        <ul>
            <li *ngFor="let course of courses">
                {{ course }}
            </li>
        </ul>
    `
})
export class CoursesComponent {  // add class name to app.module declarations, will get error if you don't
    title = "List of courses";
    courses;

    constructor(service: CoursesService) { // need to register as a provider in app.module.ts or will error
        this.courses = service.getCourses();
    }

}