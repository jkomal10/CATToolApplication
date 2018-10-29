import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForCloudProviderComponent } from './for-cloud-provider.component';
import { SetEvaluationOrderComponent } from './set-evaluation-order/set-evaluation-order.component';
import { CloudProviderRuleComponent } from './cloud-provider-rule/cloud-provider-rule.component';

const routes: Routes = [
    {
        path: '',
        component: ForCloudProviderComponent
    },
    {
        path:'app-set-evaluation-order',component: SetEvaluationOrderComponent
    },
    {
        path:'app-cloud-provider-rule' , component : CloudProviderRuleComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ForCloudProviderRoutingModule {}
