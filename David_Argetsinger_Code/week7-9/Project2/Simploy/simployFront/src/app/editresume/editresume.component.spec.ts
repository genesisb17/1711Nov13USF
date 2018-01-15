import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditresumeComponent } from './editresume.component';

describe('EditresumeComponent', () => {
  let component: EditresumeComponent;
  let fixture: ComponentFixture<EditresumeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditresumeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditresumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
