import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReportRoutingModule } from './report-routing.module';
import { ReportComponent } from './report.component';
import { AssessmentReportComponent } from './assessment-report/assessment-report.component';
import { BsDatepickerModule } from 'ngx-bootstrap';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@NgModule({
    imports: [CommonModule, ReportRoutingModule,FormsModule,BsDatepickerModule.forRoot(),NgMultiSelectDropDownModule.forRoot()],
    declarations: [ReportComponent,AssessmentReportComponent
    ]
})

export class ReportModule {}
