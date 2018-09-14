import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';

import { AssessmentQuestionsRoutingModule } from './assessment-questions-routing.module';
import { AssessmentQuestionsComponent } from './assessment-questions.component';

@NgModule({
    imports: [CommonModule, AssessmentQuestionsRoutingModule,DataTablesModule],
    declarations: [AssessmentQuestionsComponent]
})

export class AssessmentQuestionsModule {}
