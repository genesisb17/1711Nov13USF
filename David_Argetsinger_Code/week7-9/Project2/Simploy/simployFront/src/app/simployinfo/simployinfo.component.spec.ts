import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimployinfoComponent } from './simployinfo.component';

describe('SimployinfoComponent', () => {
  let component: SimployinfoComponent;
  let fixture: ComponentFixture<SimployinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimployinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimployinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
