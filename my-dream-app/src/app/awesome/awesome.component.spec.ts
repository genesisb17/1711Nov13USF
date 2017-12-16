import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AwesomeComponent } from './awesome.component';

describe('AwesomeComponent', () => {
  let component: AwesomeComponent;
  let fixture: ComponentFixture<AwesomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AwesomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AwesomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
