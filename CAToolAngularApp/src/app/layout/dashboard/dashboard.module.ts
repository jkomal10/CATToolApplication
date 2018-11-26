import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbCarouselModule, NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { YoutubePlayerModule } from 'ngx-youtube-player';
import { VgCoreModule } from 'videogular2/core';
import { VgControlsModule } from 'videogular2/controls';
import { StatModule } from '../../shared';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
@NgModule({
    imports: [
        CommonModule,
        NgbCarouselModule.forRoot(),
        NgbAlertModule.forRoot(),
        TranslateModule.forChild(),
        DashboardRoutingModule,
        StatModule,
        YoutubePlayerModule,
        VgCoreModule,
       VgControlsModule
    ],
    declarations: [
        DashboardComponent
    ]
})
export class DashboardModule {}
