import { TestBed, inject } from '@angular/core/testing';

import { ImportQuestionService } from './import-question.service';

describe('ImportQuestionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ImportQuestionService]
    });
  });

  it('should be created', inject([ImportQuestionService], (service: ImportQuestionService) => {
    expect(service).toBeTruthy();
  }));
});
