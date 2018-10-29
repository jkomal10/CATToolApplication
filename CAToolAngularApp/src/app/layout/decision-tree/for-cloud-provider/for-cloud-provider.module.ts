import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { ForCloudProviderRoutingModule } from './for-cloud-provider-routing.module';
import { ForCloudProviderComponent } from './for-cloud-provider.component';
// import { GitcComponent } from './gitc/gitc.component';
// import { AwsComponent } from './aws/aws.component';
import { SetEvaluationOrderComponent } from './set-evaluation-order/set-evaluation-order.component';
import { FormsModule } from '@angular/forms';
import { CloudProviderRuleComponent } from './cloud-provider-rule/cloud-provider-rule.component';

@NgModule({
    imports: [CommonModule, ForCloudProviderRoutingModule, DataTablesModule,FormsModule],
    declarations: [ForCloudProviderComponent, SetEvaluationOrderComponent, CloudProviderRuleComponent]
})

export class ForCloudProviderModule {}
