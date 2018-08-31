import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ForCloudableRoutingModule } from './for-cloudable-routing.module';
import { ForCloudableComponent } from './for-cloudable.component';

@NgModule({
    imports: [CommonModule, ForCloudableRoutingModule],
    declarations: [ForCloudableComponent]
})

export class ForCloudableModule {}
