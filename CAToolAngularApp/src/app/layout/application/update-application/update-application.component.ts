import { Component, OnInit, Input } from '@angular/core';

import { Router } from '@angular/router';

import { Application } from '../Application';
import { ApplicationService } from '../application.service';
import { ForMigrationPatternService } from '../../decision-tree/for-migration-pattern/for-migration-pattern.service';
import { ForCloudProviderService } from '../../decision-tree/for-cloud-provider/for-cloud-provider.service';

@Component({
  selector: 'app-update-application',
  templateUrl: './update-application.component.html',
  styleUrls: ['./update-application.component.scss']
})
export class UpdateApplicationComponent implements OnInit {
  application= new Application();
  applicationObject= new Application();
  app : any;
  migrationPatterns : any;
  cloudProviders : any;
  updatedCloudProvider:string;
  updatedMigrationPattern:string;
  
  constructor(private router: Router, private applicationService: ApplicationService, private migrationPatternService:ForMigrationPatternService, private cloudProviderService:ForCloudProviderService) { }
  
  ngOnInit() {
    this.applicationService.question.subscribe(data => {this.app= data}); 
    this.migrationPatternService.getAllMigrationData().subscribe(data => {this.migrationPatterns=data});
    this.cloudProviderService.CollectData().subscribe(data=>{this.cloudProviders = data});
    
  }

  onSelectCloudProvider(event:string)
  {
   this.updatedCloudProvider=event;
  }
  onSelectMigrationPatternr(event:string){
    
   this.updatedMigrationPattern=event;
  }
  updateActive(application) {
    this.applicationObject=application;
    this.applicationObject.modifiedBy=localStorage.getItem('userName');
    this.applicationService.updateApplication(this.applicationObject).subscribe();
    this.router.navigate(['/application']);
  }
  onSubmit(formvalues){
   
    this.application=formvalues;
    this.updateActive(this.application);
  }

}
