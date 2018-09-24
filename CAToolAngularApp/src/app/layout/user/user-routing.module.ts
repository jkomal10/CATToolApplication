import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';

const routes: Routes = [
    {
        path: '',
        component: UserComponent,
        children: [
            { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
         { path: 'adduser', loadChildren: './adduser/adduser.module#AdduserModule' }
        ]
        
    }
    
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule {}
