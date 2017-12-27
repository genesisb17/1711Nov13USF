import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { SuperBar } from '../../beans/SuperBar';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-superbars',
  templateUrl: './superbars.component.html',
  styleUrls: ['./superbars.component.css']
})
export class SuperbarsComponent implements OnInit {
  superBars: Array<SuperBar> = [];

  constructor(private http: Http) { }

  ngOnInit() {
    this.http.get(environment.getAllSuperBarsUrl).subscribe(
      succ => this.superBars = succ.json()
    );
  }

}
