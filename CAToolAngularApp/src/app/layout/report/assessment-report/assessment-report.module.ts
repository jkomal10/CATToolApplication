import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AssessmentReportRoutingModule } from './assessment-report-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
 

@NgModule({
  imports: [
    CommonModule,
    AssessmentReportRoutingModule,
    FormsModule,
    BsDatepickerModule.forRoot(),
    NgMultiSelectDropDownModule.forRoot()
  ],
  declarations: []
})
export class AssessmentReportModule { }
