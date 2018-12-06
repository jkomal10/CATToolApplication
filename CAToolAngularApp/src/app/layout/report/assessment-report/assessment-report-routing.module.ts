import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AssessmentReportComponent } from './assessment-report.component';

const routes: Routes = [
  {
      path: '',
      component: AssessmentReportComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AssessmentReportRoutingModule { }
