import { TestBed, inject } from '@angular/core/testing';

import { AssessmentQuestionsService } from './assessment-questions.service';

describe('AssessmentQuestionsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssessmentQuestionsService]
    });
  });

  it('should be created', inject([AssessmentQuestionsService], (service: AssessmentQuestionsService) => {
    expect(service).toBeTruthy();
  }));
});
