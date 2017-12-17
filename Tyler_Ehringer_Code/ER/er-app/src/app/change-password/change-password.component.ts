import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  private old: string;
  private new1: string;
  private new2: string;
  private message: string = "";

  constructor(private account: AccountService, private amodal: NgbActiveModal) { }

  ngOnInit() {
  }

  submit() {
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/
    if (this.old == this.account.getcurrentUser().password) {
      if (this.new1 == this.new2) {
        if (passwordRegex.test(this.new1)) {
          this.amodal.close(this.new1);
        } else {
          this.message = "Password must be at least 8 charactes long and have at least 1 upper case letter, 1 lower case letter, and 1 number";
        }
      } else {
        this.message = "Your new passwords did not match";
      }
    } else {
      this.message = "Your original password did not match";
    }
  }

}
