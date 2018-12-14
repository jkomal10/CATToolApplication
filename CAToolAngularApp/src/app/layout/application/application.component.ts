import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject, Observable } from '../../../../node_modules/rxjs';
import { ApplicationService } from './application.service';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';
import { NGXLogger } from 'ngx-logger';
import { LocalStorageService } from '../utility/service/localStorage.service';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss'],
  providers: [NGXLogger]
})
export class ApplicationComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  message = '';
  clientIdValue : number;
  application:Array<Application>=[];
  applicationTemplate:Array<Application>=[];
  applicationList: any = [];
  public show:boolean = false;
  public buttonName:any = 'Help';
  constructor(public router:Router, private applicationService:ApplicationService,private logger: NGXLogger,private myStorage:LocalStorageService) { }
  
  ngOnInit() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.logger.debug('************8Your log message goes here');
    this.logger.log('Your log message goes here');
    this.dtOptions = {
      pagingType: 'first_last_numbers',
      pageLength: 10,
      responsive: true,
    
  };
    this.applicationService.getAllAplication(this.clientIdValue).subscribe(result => 
      {
      this.applicationList= result ;
      this.logger.log(JSON.stringify(this.applicationList));
      this.dtTrigger.next();
      });
  }

 toggle() {
 this.show = !this.show;

 if(this.show) 
    this.buttonName = "Hide";
 else
    this.buttonName = "Help";
  }

exportTemplate(){
const csvRows = [];
this.logger.log(this.applicationList)
var filename = "Application";
let dateNow:Date=new Date();

var options = {

headers:["Application Name","Application Description","UserId"]
}; 
new Angular5Csv( this.applicationTemplate,filename, options);
}
  form(){
    this.router.navigate(['/application/add-application']);
  }

  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  myFunction()
  {
    this.router.navigate(['/application/import-application']);
  }
  editApplication(application: Application): void {
    this.logger.log(JSON.stringify(application));
    this.applicationService.sendMsgtoOtherComponent(application);
    this.router.navigate(['/application/update-application']);
  }
  exportCsv(){
    const csvRows = [];
    this.logger.log(this.applicationList)
    var filename = "Application";
   
    let dateNow:Date=new Date();
    this.logger.log(dateNow.getDate().toString+" Date");
    this.logger.log(dateNow.getDay().toString+" day");
    this.logger.log(dateNow.getMonth().toString+ " month");
    this.logger.log(dateNow.getFullYear().toString+" year");


    for (let index = 0; index < this.applicationList.length; index++) {
      this.logger.log(this.applicationList[index].applicationId+"id");
      this.application[index]=this.applicationList[index];
    }

    this.logger.log(this.application);
    var options = {
      headers:["ApplicationId","Application Name","Application Description","IsCloudable","MigrationPattern",
              "CloudProvider","IsAssessment","IsFinalized","IsDeleted","IsDeactivated","DeleteDateAndTime",
               "Isverified","CreatedDate","ModifiedDateTime","CreatedBy","ModifiedBy","UserId","IsSaved"]
    };

   new Angular5Csv(this.application, filename, options);

  }

  
  deleteApplication(formvalues) {
    this.applicationService.deleteApplications(formvalues)
    .subscribe(
      data => {
        this.logger.log(data);
        this.reloadData();
      },
      error => console.log('ERROR: ' + error));
  }

  resetApplication(formvalues){
    this.applicationService.resetApplication(formvalues)
    .subscribe();
  }

   reloadData() {
     this.applicationService.getAllAplication(this.clientIdValue);
   }
   
   ViewApplication(formvalues){
     this.applicationService.sendMsgtoOtherComponent(formvalues);
     this.logger.log(formvalues);
    this.router.navigate(['/application/view-application']);
   }
   assessApplication(formvalues){
    this.logger.log(JSON.stringify(formvalues));
    this.logger.log(formvalues.applicationId)
    console.log(JSON.stringify(formvalues));
    this.applicationService.sendMsgtoOtherComponent(formvalues);
     this.router.navigate(['/application/assesst-application']);

   }

   deactivate(formvalues){
     this.applicationService.deactivate(formvalues).subscribe();
   }
}
