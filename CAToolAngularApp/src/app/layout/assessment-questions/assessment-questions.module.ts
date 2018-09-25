import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AssessmentQuestionsRoutingModule } from './assessment-questions-routing.module';
import { AssessmentQuestionsComponent } from './assessment-questions.component';
import { AssessmentQuestionsService } from './assessment-questions.service';


@NgModule({
    imports: [CommonModule, AssessmentQuestionsRoutingModule,DataTablesModule,FormsModule,ReactiveFormsModule],
    declarations: [AssessmentQuestionsComponent],
    providers: [AssessmentQuestionsService]
})

export class AssessmentQuestionsModule {}
