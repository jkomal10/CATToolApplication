import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplicationComponent } from './application.component';
import { AddApplicationComponent} from './add-application/add-application.component';
import { ImportApplicationComponent } from './import-application/import-application.component';

const routes: Routes = [
    { path: '', component: ApplicationComponent},    
    { path: 'add-application', component: AddApplicationComponent },
    { path: 'import-application', component: ImportApplicationComponent }     
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ApplicationRoutingModule {}
