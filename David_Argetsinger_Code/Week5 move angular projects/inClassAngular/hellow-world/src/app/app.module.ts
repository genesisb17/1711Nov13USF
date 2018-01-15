import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { CoursesComponent } from './courses.component';
import { CourseComponent } from './course/course.component';
import { CoursesService } from './courses.service';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    CoursesComponent,
    CourseComponent,
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [CoursesService],
  bootstrap: [AppComponent]
})//providers used for dependancies importing 
export class AppModule { }
