import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';

import { CatloginRoutingModule } from './catlogin-routing.module';
import { CATloginComponent } from './catlogin.component';

@NgModule({
  imports: [
    CommonModule, CatloginRoutingModule,FormsModule,ReactiveFormsModule
  ],
  declarations: [CATloginComponent]
})
export class CatloginModule { }
