import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UploadUserComponent } from './upload-user/upload-user.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { UserRoleComponent } from './user-role/user-role.component';
import { YoutubePlayerModule } from 'ngx-youtube-player';


@NgModule({
    imports: [CommonModule, UserRoutingModule,DataTablesModule,FormsModule,YoutubePlayerModule],
    declarations: [UserComponent, AddUserComponent, UpdateUserComponent, UploadUserComponent, ChangePasswordComponent, UserRoleComponent]
})

export class UserModule {}
