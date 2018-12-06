import { TestBed, inject } from '@angular/core/testing';

import { AssessmentReportService } from './assessment-report.service';

describe('AssessmentReportService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssessmentReportService]
    });
  });

  it('should be created', inject([AssessmentReportService], (service: AssessmentReportService) => {
    expect(service).toBeTruthy();
  }));
});
