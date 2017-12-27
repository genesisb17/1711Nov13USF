import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperbarComponent } from './superbar.component';

describe('SuperbarComponent', () => {
  let component: SuperbarComponent;
  let fixture: ComponentFixture<SuperbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
