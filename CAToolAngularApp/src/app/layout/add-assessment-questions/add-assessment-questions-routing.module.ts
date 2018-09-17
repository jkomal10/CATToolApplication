import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAssessmentQuestionsComponent } from './add-assessment-questions.component';

const routes: Routes = [
    {
        path: '',
        component: AddAssessmentQuestionsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AddAssessmentQuestionsRoutingModule {}