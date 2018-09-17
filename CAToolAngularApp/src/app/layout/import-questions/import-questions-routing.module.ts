import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ImportQuestionsComponent } from './import-questions.component';

const routes: Routes = [
    {
        path: '',
        component : ImportQuestionsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ImportQuestionsRoutingModule {}
