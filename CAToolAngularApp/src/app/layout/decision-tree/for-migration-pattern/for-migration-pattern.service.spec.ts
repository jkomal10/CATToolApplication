import { TestBed, inject } from '@angular/core/testing';

import { ForMigrationPatternService } from './for-migration-pattern.service';

describe('ForMigrationPatternService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ForMigrationPatternService]
    });
  });

  it('should be created', inject([ForMigrationPatternService], (service: ForMigrationPatternService) => {
    expect(service).toBeTruthy();
  }));
});
