import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {AdduserComponent} from './adduser.component';

const routes: Routes = [
  {
      path: '',
      component: AdduserComponent,
      
      
  }
  
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AdduserRoutingModule { }
