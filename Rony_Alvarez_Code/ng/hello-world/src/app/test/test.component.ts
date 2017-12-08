import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'courses',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  title = "List of courses";

  getTitle() {
    return this.getTitle;
  }

  constructor() { }

  ngOnInit() {
  }

}
