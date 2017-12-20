import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment.prod';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent {
  title = 'app';
  results = '';
  // API_URL = environment.apiUrl;
  // API_KEY = environment.apiKey;


  constructor(private http : HttpClient){

  }
  
  ngOnInit(): void{
    this.http.get('https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=1min&apikey=UPV13E9LU5CSGA8F').subscribe(
      data => {
        console.log(data);
      });
  }

  login = require("facebook-chat-api");
  login({email: "FB_EMAIL", password: "FB_PASSWORD"}, (err, api) => {
    if(err) return console.error(err);
 
    api.listen((err, message) => {
        api.sendMessage(message.body, message.threadID);
    });
});

}
