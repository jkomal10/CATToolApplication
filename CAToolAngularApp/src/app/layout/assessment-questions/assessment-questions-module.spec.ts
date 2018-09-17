import { AssessmentQuestionsModule } from "./assessment-questions.module";

describe('AssessmentQuestionsModule', () => {
    let assessmentQuestionsModule: AssessmentQuestionsModule;

    beforeEach(() => {
        assessmentQuestionsModule = new AssessmentQuestionsModule();
    });

    it('should create an instance', () => {
        expect(assessmentQuestionsModule).toBeTruthy();
    });
});
