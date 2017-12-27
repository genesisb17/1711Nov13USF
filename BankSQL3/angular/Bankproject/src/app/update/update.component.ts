import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  Update(Balance:number)
  {
    console.log(Balance);
    Balance = Balance+2;
    console.log(Balance);
  }
}
