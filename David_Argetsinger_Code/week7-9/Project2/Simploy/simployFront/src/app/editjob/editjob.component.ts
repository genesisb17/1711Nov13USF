import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editjob',
  templateUrl: './editjob.component.html',
  styleUrls: ['./editjob.component.css']
})
export class EditjobComponent implements OnInit {

  constructor(private router: Router ) { }
  ngOnInit() {
  }

  updateJob(e) {

  }

  backToViewSingleJob() {
    this.router.navigate(['./viewsinglejob']);
  }

}
