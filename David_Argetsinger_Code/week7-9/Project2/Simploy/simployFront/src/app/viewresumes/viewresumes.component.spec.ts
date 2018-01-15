import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewresumesComponent } from './viewresumes.component';

describe('ViewresumesComponent', () => {
  let component: ViewresumesComponent;
  let fixture: ComponentFixture<ViewresumesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewresumesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewresumesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
