import { TestBed, inject } from '@angular/core/testing';

import { SportsserviceService } from './sportsservice.service';

describe('SportsserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SportsserviceService]
    });
  });

  it('should be created', inject([SportsserviceService], (service: SportsserviceService) => {
    expect(service).toBeTruthy();
  }));
});
