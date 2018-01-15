import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitresumeComponent } from './submitresume.component';

describe('SubmitresumeComponent', () => {
  let component: SubmitresumeComponent;
  let fixture: ComponentFixture<SubmitresumeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitresumeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitresumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
