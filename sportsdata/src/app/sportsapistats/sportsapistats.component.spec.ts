import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SportsapistatsComponent } from './sportsapistats.component';

describe('SportsapistatsComponent', () => {
  let component: SportsapistatsComponent;
  let fixture: ComponentFixture<SportsapistatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SportsapistatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SportsapistatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
