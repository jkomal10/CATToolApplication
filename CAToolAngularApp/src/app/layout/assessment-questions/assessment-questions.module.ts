import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AssessmentQuestionsRoutingModule } from './assessment-questions-routing.module';
import { AssessmentQuestionsComponent } from './assessment-questions.component';
import { AssessmentQuestionsService } from './assessment-questions.service';
import { ImportQuestionComponent } from './import-question/import-question.component';
import { AddAssessmentQuestionComponent } from './add-assessment-question/add-assessment-question.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';


@NgModule({
    imports: [CommonModule, AssessmentQuestionsRoutingModule,DataTablesModule,FormsModule,ReactiveFormsModule],
    declarations: [AssessmentQuestionsComponent, ImportQuestionComponent, AddAssessmentQuestionComponent, UpdateQuestionComponent],
    providers: [AssessmentQuestionsService]
})

export class AssessmentQuestionsModule {}
