import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AddAssessmentQuestionsRoutingModule } from './add-assessment-questions-routing.module';
import { AddAssessmentQuestionsComponent } from './add-assessment-questions.component';
import { AddAssessmentQuestionsService } from './add-assessment-questions.service';


@NgModule({
    imports: [CommonModule,AddAssessmentQuestionsRoutingModule,DataTablesModule,FormsModule,ReactiveFormsModule],
    declarations: [AddAssessmentQuestionsComponent],
    providers: [AddAssessmentQuestionsService]
})

export class AddAssessmentQuestionsModule {}
