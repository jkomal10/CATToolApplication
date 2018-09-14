import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';

import { ApplicationRoutingModule } from './application-routing.module';
import { ApplicationComponent } from './application.component';

@NgModule({
    imports: [CommonModule, ApplicationRoutingModule,DataTablesModule],
    declarations: [ApplicationComponent]
})

export class ApplicationModule {}
