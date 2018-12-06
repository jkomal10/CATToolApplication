import { AssessmentReportModule } from './assessment-report.module';

describe('AssessmentReportModule', () => {
  let assessmentReportModule: AssessmentReportModule;

  beforeEach(() => {
    assessmentReportModule = new AssessmentReportModule();
  });

  it('should create an instance', () => {
    expect(assessmentReportModule).toBeTruthy();
  });
});
