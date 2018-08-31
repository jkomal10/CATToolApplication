import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ForCloudProviderRoutingModule } from './for-cloud-provider-routing.module';
import { ForCloudProviderComponent } from './for-cloud-provider.component';

@NgModule({
    imports: [CommonModule, ForCloudProviderRoutingModule],
    declarations: [ForCloudProviderComponent]
})

export class ForCloudProviderModule {}
