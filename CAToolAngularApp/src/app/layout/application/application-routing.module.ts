import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplicationComponent } from './application.component';
import { AddApplicationComponent} from './add-application/add-application.component';
import { ImportApplicationComponent } from './import-application/import-application.component';
import { ViewApplicationComponent } from './view-application/view-application.component';
import { AssesstApplicationComponent } from './assesst-application/assesst-application.component';
import { UpdateApplicationComponent } from './update-application/update-application.component';

const routes: Routes = [
    { path: '', component: ApplicationComponent},    
    { path: 'add-application', component: AddApplicationComponent },
    { path: 'import-application', component: ImportApplicationComponent },
    { path: 'view-application', component: ViewApplicationComponent },  
    { path: 'assesst-application', component: AssesstApplicationComponent }, 
    { path: 'update-application', component: UpdateApplicationComponent},
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ApplicationRoutingModule {}
