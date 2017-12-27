import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { SuperBar } from '../../beans/superbar';

@Component({
  selector: 'app-superbar',
  templateUrl: './superbar.component.html',
  styleUrls: ['./superbar.component.css']
})
export class SuperbarComponent implements OnInit {
  superBars: Array<SuperBar>=[];

  constructor(private http: Http) { }

  ngOnInit() {
    this.http.get('http://localhost/superbars').subscribe(
      succ=>this.superBars=succ.json()
    );
  }

}
