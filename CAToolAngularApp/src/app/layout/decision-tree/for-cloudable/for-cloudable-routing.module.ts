import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForCloudableComponent } from './for-cloudable.component';

const routes: Routes = [
    {
        path: '',
        component: ForCloudableComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForCloudableRoutingModule {}
