import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { ApplicationRoutingModule } from './application-routing.module';
import { ApplicationComponent } from './application.component';
import { AddApplicationComponent } from './add-application/add-application.component';
import { ImportApplicationComponent } from './import-application/import-application.component';
import { ViewApplicationComponent } from './view-application/view-application.component';
import { AssesstApplicationComponent } from './assesst-application/assesst-application.component';
import { UpdateApplicationComponent } from './update-application/update-application.component';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';
@NgModule({
    imports: [CommonModule, ApplicationRoutingModule,DataTablesModule,FormsModule
    ,LoggerModule.forRoot({level: NgxLoggerLevel.LOG,disableConsoleLogging:false,serverLogLevel: NgxLoggerLevel.LOG})],
    declarations: [
        ApplicationComponent,
         AddApplicationComponent,
          ImportApplicationComponent,
          ViewApplicationComponent,
          AssesstApplicationComponent,
          UpdateApplicationComponent
        ]
})

export class ApplicationModule {}
