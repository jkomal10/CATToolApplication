import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CATloginComponent } from './catlogin.component';

const routes: Routes = [
  { path: '', component: CATloginComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CatloginRoutingModule { }
