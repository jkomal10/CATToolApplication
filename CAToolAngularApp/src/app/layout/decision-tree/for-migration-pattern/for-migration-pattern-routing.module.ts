import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';
import { PublicPassComponent } from './public-pass/public-pass.component';
import { EvaluationOrderComponent } from './evaluation-order/evaluation-order.component';

const routes: Routes = [
    {
        path: '',
        component: ForMigrationPatternComponent
    },
    { path: 'public-pass', component: PublicPassComponent },
    { path: 'evaluation-order', component: EvaluationOrderComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForMigrationPatternRoutingModule {}
