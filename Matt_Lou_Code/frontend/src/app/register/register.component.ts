import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  //userInfo: User;

  model: any = {};
  loading = false;
  constructor(private registerService: RegisterService, private router: Router) { }

  register() {
    this.loading = true;
    this.registerService.register(this.model);
    this.router.navigate(['/login']);
  }

  ngOnInit() {
    
  }

}
