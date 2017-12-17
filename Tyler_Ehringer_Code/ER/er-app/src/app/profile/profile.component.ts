import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { User } from '../types/user.type';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ChangePasswordComponent } from '../change-password/change-password.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  private user: User;

  constructor(private router: Router, private account: AccountService, private modal: NgbModal) { }

  ngOnInit() {
    this.user = this.account.getcurrentUser();
  }

  changePassword() {
    var modal = this.modal.open(ChangePasswordComponent);
    modal.result.then(p => {
      this.user.password = p;
    }, reason => { })
  }

  save() {
    this.account.updateUser(this.user);
    this.router.navigate(["reimbursements"]);
  }

}
