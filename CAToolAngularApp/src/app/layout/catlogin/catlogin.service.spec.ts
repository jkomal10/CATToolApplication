import { TestBed, inject } from '@angular/core/testing';

import { CatloginService } from './catlogin.service';

describe('CatloginService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CatloginService]
    });
  });

  it('should be created', inject([CatloginService], (service: CatloginService) => {
    expect(service).toBeTruthy();
  }));
});
