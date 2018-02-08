import { Component, OnInit } from '@angular/core';
import {SportsserviceService} from '../sportsservice.service';
@Component({
  selector: 'app-sportsapistats',
  templateUrl: './sportsapistats.component.html',
  styleUrls: ['./sportsapistats.component.css']
})
export class SportsapistatsComponent implements OnInit 
{    
  constructor(private sport:SportsserviceService) { }  
  ngOnInit() 
  {    
    this.sport.getData('http://data.nba.net/10s/prod/v1/today.json');  
  }
}