import { TestBed, inject } from '@angular/core/testing';

import { UpdateAccountService } from './update-account.service';

describe('UpdateAccountService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UpdateAccountService]
    });
  });

  it('should be created', inject([UpdateAccountService], (service: UpdateAccountService) => {
    expect(service).toBeTruthy();
  }));
});
