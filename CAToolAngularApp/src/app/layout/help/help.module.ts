import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HelpRoutingModule } from './help-routing.module';
import { HelpComponent } from './help.component';
import { YoutubePlayerModule } from 'ngx-youtube-player';

@NgModule({
  imports: [
    CommonModule,
    HelpRoutingModule,
    YoutubePlayerModule
  ],
  declarations: [HelpComponent]
})
export class HelpModule { }
