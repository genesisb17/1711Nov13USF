import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { User } from '../types/user.type';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  private user: User;
  private fname: string;

  constructor(private account: AccountService, private router: Router) { }

  ngOnInit() {
    this.user = this.account.getcurrentUser();
    this.fname = this.user.fname;
  }

}
