import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LginComponent } from './lgin.component';

describe('LginComponent', () => {
  let component: LginComponent;
  let fixture: ComponentFixture<LginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});