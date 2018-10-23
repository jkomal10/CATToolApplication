import { TestBed, inject } from '@angular/core/testing';

import { PublicPassService } from './public-pass.service';

describe('PublicPassService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PublicPassService]
    });
  });

  it('should be created', inject([PublicPassService], (service: PublicPassService) => {
    expect(service).toBeTruthy();
  }));
});
