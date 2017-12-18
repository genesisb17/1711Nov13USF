import { TestBed, inject } from '@angular/core/testing';

import { UserApiServiceService } from './user-api-service.service';

describe('UserApiServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserApiServiceService]
    });
  });

  it('should be created', inject([UserApiServiceService], (service: UserApiServiceService) => {
    expect(service).toBeTruthy();
  }));
});
