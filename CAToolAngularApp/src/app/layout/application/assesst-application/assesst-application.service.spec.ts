import { TestBed, inject } from '@angular/core/testing';

import { AssesstApplicationService } from './assesst-application.service';

describe('AssesstApplicationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssesstApplicationService]
    });
  });

  it('should be created', inject([AssesstApplicationService], (service: AssesstApplicationService) => {
    expect(service).toBeTruthy();
  }));
});
