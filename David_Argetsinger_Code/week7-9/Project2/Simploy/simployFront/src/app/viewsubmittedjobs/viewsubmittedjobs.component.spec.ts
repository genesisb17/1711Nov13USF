import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsubmittedjobsComponent } from './viewsubmittedjobs.component';

describe('ViewsubmittedjobsComponent', () => {
  let component: ViewsubmittedjobsComponent;
  let fixture: ComponentFixture<ViewsubmittedjobsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewsubmittedjobsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewsubmittedjobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
