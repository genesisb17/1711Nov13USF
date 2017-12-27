import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperbarsComponent } from './superbars.component';

describe('SuperbarsComponent', () => {
  let component: SuperbarsComponent;
  let fixture: ComponentFixture<SuperbarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperbarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperbarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
