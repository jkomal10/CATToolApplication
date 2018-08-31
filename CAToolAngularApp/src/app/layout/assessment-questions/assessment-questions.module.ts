import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AssessmentQuestionsRoutingModule } from './assessment-questions-routing.module';
import { AssessmentQuestionsComponent } from './assessment-questions.component';

@NgModule({
    imports: [CommonModule, AssessmentQuestionsRoutingModule],
    declarations: [AssessmentQuestionsComponent]
})

export class AssessmentQuestionsModule {}
