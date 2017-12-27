import { TestBed, inject } from '@angular/core/testing';

import { ChuckNorrisService } from './chuck-norris.service';

describe('ChuckNorrisService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChuckNorrisService]
    });
  });

  it('should be created', inject([ChuckNorrisService], (service: ChuckNorrisService) => {
    expect(service).toBeTruthy();
  }));
});
