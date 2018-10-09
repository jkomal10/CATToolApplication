import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UploadUserComponent } from './upload-user/upload-user.component';

const routes: Routes = [
    { path: '',component: UserComponent},
    { path: 'add-user',component: AddUserComponent},
    { path: 'update-user',component: UpdateUserComponent},
    { path: 'upload-user' , component: UploadUserComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule {}
