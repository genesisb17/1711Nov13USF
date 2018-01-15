import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsingleresumeComponent } from './viewsingleresume.component';

describe('ViewsingleresumeComponent', () => {
  let component: ViewsingleresumeComponent;
  let fixture: ComponentFixture<ViewsingleresumeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewsingleresumeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewsingleresumeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
