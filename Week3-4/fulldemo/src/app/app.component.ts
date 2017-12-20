import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 

  results: string;
  
   // Inject HttpClient into your component or service.
   constructor(private http: HttpClient) {}
  
   ngOnInit(): void {
     // Make the HTTP request:
     this.http.get('https://swapi.co/api/people/1/').subscribe(data => {
       // Read the result field from the JSON response.
       this.results = data['results'];
     });
   }



}
