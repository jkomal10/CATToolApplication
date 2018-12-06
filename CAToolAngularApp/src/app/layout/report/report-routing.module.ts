import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReportComponent } from './report.component';
import { AssessmentReportComponent } from './assessment-report/assessment-report.component';

const routes: Routes = [
    {
        path: '',
        component: ReportComponent
    },
    { path: 'assessment-report', component: AssessmentReportComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ReportRoutingModule {}
