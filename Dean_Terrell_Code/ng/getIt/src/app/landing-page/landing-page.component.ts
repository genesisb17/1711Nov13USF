import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { StudySetService } from '../study-set.service';
import { StudySet } from '../studyset';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent  {

  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    let dialogRef = this.dialog.open(CreateStudysetModal, {
      width: '250px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}

@Component({
  selector: 'dialog-overview-example-dialog',
  template: `<div class="example-container">
              <section class="mat-typography">
                <h2 style="text-align:center;">New Studyset</h2>
              </section>
              <mat-form-field>
               <input matInput [(ngModel)]="  name" placeholder="Studyset Name">
              </mat-form-field>
              <div style="display: flex; justify-content:center;">
              <button mat-button (click)="createStudySet()">Create</button> </div>
            </div>`,
})
export class CreateStudysetModal {

  name = '';
  set : StudySet = new StudySet();

  constructor(private setService: StudySetService,
    public dialogRef: MatDialogRef<CreateStudysetModal>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  createStudySet() {
    this.set.name = this.name;
    this.setService.addStudySet(this.set);
  }
}