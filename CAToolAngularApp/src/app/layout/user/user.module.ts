import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { AdduserComponent } from './adduser/adduser.component';

@NgModule({
    imports: [CommonModule, UserRoutingModule,DataTablesModule,FormsModule],
    declarations: [UserComponent, AdduserComponent]
})

export class UserModule {}
