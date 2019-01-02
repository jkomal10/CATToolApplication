import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { ForCloudProviderRoutingModule } from './for-cloud-provider-routing.module';
import { ForCloudProviderComponent } from './for-cloud-provider.component';

import { SetEvaluationOrderComponent } from './set-evaluation-order/set-evaluation-order.component';
import { CloudProviderRuleComponent } from './cloud-provider-rule/cloud-provider-rule.component';

@NgModule({
    imports: [CommonModule, ForCloudProviderRoutingModule, DataTablesModule,FormsModule],
    declarations: [ForCloudProviderComponent, SetEvaluationOrderComponent, CloudProviderRuleComponent]
})

export class ForCloudProviderModule {}
