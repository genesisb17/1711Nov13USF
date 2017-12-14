import { Component } from '@angular/core';
import { DataService } from './data.service';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  dukes = {"id":5,"amount":300,"submitted":null,"resolved":null,"description":"Relocation","receipt":null,"author":1,"resolver":1,"statusId":26,"typeId":1}
  
  title = 'app';

  constructor(private http: Http) {

  }

  ngOnInit() {
    this.http.get('http://localhost:9999/ExpenseReimbursementSystem/AllTickets').toPromise();
  }

}
