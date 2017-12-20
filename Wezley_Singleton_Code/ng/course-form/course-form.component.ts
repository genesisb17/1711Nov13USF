import { Component } from '@angular/core';

@Component({
  selector: 'course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent {

  categories = [
    { id: 1, name: 'Technology - Programming Languages' },
    { id: 2, name: 'Technology - Scripting Languages' },
    { id: 3, name: 'Technology - Markup Languages' },
    { id: 4, name: 'Technology - Hardware' }
  ];

  log(x) { console.log(x); }

  submit(f) {
    console.log(f.value);
  }

}
