import { TestBed, inject } from '@angular/core/testing';

import { ForCloudProviderService } from './for-cloud-provider.service';

describe('ForCloudProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ForCloudProviderService]
    });
  });

  it('should be created', inject([ForCloudProviderService], (service: ForCloudProviderService) => {
    expect(service).toBeTruthy();
  }));
});
