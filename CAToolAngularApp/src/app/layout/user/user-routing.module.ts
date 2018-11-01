import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UploadUserComponent } from './upload-user/upload-user.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { UserRoleComponent } from './user-role/user-role.component';

const routes: Routes = [
    { path: '',component: UserComponent},
    { path: 'add-user',component: AddUserComponent},
    { path: 'user-role',component: UserRoleComponent},
    { path: 'update-user',component: UpdateUserComponent},
    { path: 'upload-user' , component: UploadUserComponent},
    { path: 'change-password' , component: ChangePasswordComponent},
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule {}
