import { CoursesService } from './course/courses.service';


import { Component } from '@angular/core';


@Component({

    selector: 'courses', // <div class="courses"> "#courses"
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

    //logic for calling an HTTP service

    constructor(service: CoursesService) {
        
        this.courses = service.getCourses;
    }
}