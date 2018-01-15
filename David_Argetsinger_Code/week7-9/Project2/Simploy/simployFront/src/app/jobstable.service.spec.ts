import { TestBed, inject } from '@angular/core/testing';

import { JobstableService } from './jobstable.service';

describe('JobstableService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JobstableService]
    });
  });

  it('should be created', inject([JobstableService], (service: JobstableService) => {
    expect(service).toBeTruthy();
  }));
});
