import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ChangePasswordComponent } from './change-password.component';
import { ChangePasswordService } from './change-password.service';


@NgModule({
    imports: [CommonModule,FormsModule,ReactiveFormsModule],
    declarations: [ChangePasswordComponent],
    providers: [ChangePasswordService]
})
export class ChangePasswordModule {}