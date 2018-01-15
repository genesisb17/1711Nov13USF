import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewjobsComponent } from './viewjobs.component';

describe('ViewjobsComponent', () => {
  let component: ViewjobsComponent;
  let fixture: ComponentFixture<ViewjobsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewjobsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewjobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
