import { TestBed, inject } from '@angular/core/testing';

import { ForCloudableService } from './for-cloudable.service';

describe('ForCloudableService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ForCloudableService]
    });
  });

  it('should be created', inject([ForCloudableService], (service: ForCloudableService) => {
    expect(service).toBeTruthy();
  }));
});
