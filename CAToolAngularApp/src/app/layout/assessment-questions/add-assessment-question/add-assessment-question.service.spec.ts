import { TestBed, inject } from '@angular/core/testing';

import { AddAssessmentQuestionService } from './add-assessment-question.service';

describe('AddAssessmentQuestionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddAssessmentQuestionService]
    });
  });

  it('should be created', inject([AddAssessmentQuestionService], (service: AddAssessmentQuestionService) => {
    expect(service).toBeTruthy();
  }));
});
