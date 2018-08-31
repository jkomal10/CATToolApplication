import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForCloudProviderComponent } from './for-cloud-provider.component';

const routes: Routes = [
    {
        path: '',
        component: ForCloudProviderComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForCloudProviderRoutingModule {}
