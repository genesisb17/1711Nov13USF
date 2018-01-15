import {Component} from '@angular/core'
import { CoursesService } from './courses.service';
@Component({
    selector:'courses', // 
   // template:'<h2>{{getTitle()}}</h2>' string interplextion 
   template:`
   <h2>{{title}}</h2> 
   <ul> 
    <!--enhased for loop!?--> 
        <li *ngFor="let course of courses">
        {{course}}
        </li> 
    </ul>`
})

export class CoursesComponent{
    title="list of courses";
    courses;
    constructor(service:CoursesService){
        //we decouple by sending as a param 
       // let service = new CoursesService();
        this.courses=service.getCourses();
    }


    getTitle(){
        return this.title;
    }

    //logic for calling a http service 

}