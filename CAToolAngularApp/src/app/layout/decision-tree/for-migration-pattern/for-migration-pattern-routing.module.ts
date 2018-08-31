import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';

const routes: Routes = [
    {
        path: '',
        component: ForMigrationPatternComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForMigrationPatternRoutingModule {}
