import { TestBed, inject } from '@angular/core/testing';

import { ViewApplicationService } from './view-application.service';

describe('ViewApplicationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViewApplicationService]
    });
  });

  it('should be created', inject([ViewApplicationService], (service: ViewApplicationService) => {
    expect(service).toBeTruthy();
  }));
});
