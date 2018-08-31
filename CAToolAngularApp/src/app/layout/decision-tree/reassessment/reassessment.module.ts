import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ReassessmentRoutingModule } from './reassessment-routing.module';
import { ReassessmentComponent } from './reassessment.component';

@NgModule({
    imports: [CommonModule, ReassessmentRoutingModule],
    declarations: [ReassessmentComponent]
})

export class ReassessmentModule {}
