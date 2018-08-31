import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ApplicationRoutingModule } from './application-routing.module';
import { ApplicationComponent } from './application.component';

@NgModule({
    imports: [CommonModule, ApplicationRoutingModule],
    declarations: [ApplicationComponent]
})

export class ApplicationModule {}
