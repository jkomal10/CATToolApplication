import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { ForCloudableRoutingModule } from './for-cloudable-routing.module';
import { ForCloudableComponent } from './for-cloudable.component';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [CommonModule, ForCloudableRoutingModule,FormsModule,DataTablesModule],
    declarations: [ForCloudableComponent]
})

export class ForCloudableModule {}
