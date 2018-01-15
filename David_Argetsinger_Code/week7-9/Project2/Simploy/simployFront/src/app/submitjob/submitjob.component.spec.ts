import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitjobComponent } from './submitjob.component';

describe('SubmitjobComponent', () => {
  let component: SubmitjobComponent;
  let fixture: ComponentFixture<SubmitjobComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitjobComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitjobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
