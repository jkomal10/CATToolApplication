import { TestBed, inject } from '@angular/core/testing';

import { AddAssessmentQuestionsService } from './add-assessment-questions.service';

describe('AddAssessmentQuestionsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddAssessmentQuestionsService]
    });
  });

  it('should be created', inject([AddAssessmentQuestionsService], (service: AddAssessmentQuestionsService) => {
    expect(service).toBeTruthy();
  }));
});
