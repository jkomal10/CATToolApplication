import { TestBed, inject } from '@angular/core/testing';

import { UpdateQuestionService } from './update-question.service';

describe('UpdateQuestionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UpdateQuestionService]
    });
  });

  it('should be created', inject([UpdateQuestionService], (service: UpdateQuestionService) => {
    expect(service).toBeTruthy();
  }));
});
