import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';

@NgModule({
    imports: [CommonModule, UserRoutingModule,DataTablesModule],
    declarations: [UserComponent]
})

export class UserModule {}
