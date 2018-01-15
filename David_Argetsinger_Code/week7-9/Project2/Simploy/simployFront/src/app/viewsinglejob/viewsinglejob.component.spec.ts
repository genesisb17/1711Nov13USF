import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsinglejobComponent } from './viewsinglejob.component';

describe('ViewsinglejobComponent', () => {
  let component: ViewsinglejobComponent;
  let fixture: ComponentFixture<ViewsinglejobComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewsinglejobComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewsinglejobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
