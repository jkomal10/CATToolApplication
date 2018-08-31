import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReassessmentComponent } from './reassessment.component';

const routes: Routes = [
    {
        path: '',
        component: ReassessmentComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ReassessmentRoutingModule {}
