import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';
import { EvaluationOrderComponent } from './evaluation-order/evaluation-order.component';
import { MigrationPatternsComponent } from './migration-patterns/migration-patterns.component';

const routes: Routes = [
    {
        path: '',
        component: ForMigrationPatternComponent
    },
    { path: 'evaluation-order', component: EvaluationOrderComponent },
    { path: 'migration-patterns', component: MigrationPatternsComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForMigrationPatternRoutingModule {}
