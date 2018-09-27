import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AssessmentQuestionsComponent } from './assessment-questions.component';
import { ImportQuestionComponent } from './import-question/import-question.component';
import { AddAssessmentQuestionComponent } from './add-assessment-question/add-assessment-question.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';

const routes: Routes = [
    {
        path: '',
        component: AssessmentQuestionsComponent
    },
    { path: 'import-question', component: ImportQuestionComponent },
    { path: 'add-assessment-question', component: AddAssessmentQuestionComponent },
    { path: 'update-question', component: UpdateQuestionComponent } 
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AssessmentQuestionsRoutingModule {}
