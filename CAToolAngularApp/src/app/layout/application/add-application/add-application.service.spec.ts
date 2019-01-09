import { TestBed, inject } from '@angular/core/testing';

import { AddApplicationService } from './add-application.service';

describe('AddApplicationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddApplicationService]
    });
  });

  it('should be created', inject([AddApplicationService], (service: AddApplicationService) => {
    expect(service).toBeTruthy();
  }));
});
