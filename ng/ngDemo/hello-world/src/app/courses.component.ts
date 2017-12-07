import {Component} from '@angular/core';

@Component({
    //properties to tell Angular how the component works
    selector: 'courses', //uses css selectors ; with components we can extend HTML vocab. we're trying to define an element named 'courses'
    template: '<h2>{{title}}</h2>' //html markup
    //expressions are evaluated at runtime; data binding; we are binding our view with our component
})
export class CoursesComponent{
    title = "List of course";

}