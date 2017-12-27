import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css'],
  providers: [UserService]
})
export class UserAccountComponent implements OnInit {

  name: string = '';
  text: string;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
  }

  onNameKeyUp(event: any) {
    this.name = event.target.value;
  }

  getProfile() {
    console.log(this.name);
    this.httpClient.get('http://localhost:8091/getAll').subscribe(
      (data: any[]) => {
        console.log(data[0].pw);
      }
    );
  }

  testPostMethod() {
    this.httpClient.post('http://localhost:8091/testPost',
    {
      text: 'test'
    }
  ).subscribe(
    (data: any) => {
      console.log(data);
    }
  );

  }

}
