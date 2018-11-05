import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';
import {ReassessmentRoutingModule } from './reassessment-routing.module';
import { ReassessmentComponent } from './reassessment.component';

@NgModule({
    imports: [CommonModule, ReassessmentRoutingModule,DataTablesModule,FormsModule],
    declarations: [ReassessmentComponent]
})

export class ReassessmentModule {}
