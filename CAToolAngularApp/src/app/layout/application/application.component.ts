import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject, Observable } from '../../../../node_modules/rxjs';
import { ApplicationService } from './application.service';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  message = '';
  clientNameValue : string;
  //applictaions: Observable<Application[]>;
  application:Array<Application>=[];
  applicationTemplate:Array<Application>=[];
  AllData : any = [];
  public show:boolean = false;
  public buttonName:any = 'Help';
  constructor(public router:Router, private applicationService:ApplicationService,private http:HttpClient) { }
  
  ngOnInit() {
    this.clientNameValue=localStorage.getItem('clientName');
    this.dtOptions = {
      pagingType: 'first_last_numbers',
      pageLength: 10,
      responsive: true,
    //   rowCallback: (row: Node, data: any[] | Object, index: number) => {
    //     const self = this;
    //     // Unbind first in order to avoid any duplicate handler
    //     // (see https://github.com/l-lin/angular-datatables/issues/87)
    //     $('td', row).unbind('click');
    //     $('td', row).bind('click', () => {
    //       self.someClickHandler(data);
    //     });
    //     return row;
    // }
  };

  // this.applicationService.CollectData().subscribe(result => 
  //   {
  //   this.AllData = result ;
  //   this.dtTrigger.next();
  //   });

    this.applicationService.CollectData(this.clientNameValue).subscribe(result => 
      {
      this.AllData = result ;
      console.log(JSON.stringify(this.AllData));
      this.dtTrigger.next();
      });


  }

 toggle() {
 this.show = !this.show;

// CHANGE THE NAME OF THE BUTTON.
 if(this.show) 
    this.buttonName = "Hide";
 else
    this.buttonName = "Help";
  }

exportTemplate(){
const csvRows = [];
console.log(this.AllData)
var filename = "Application";
let dateNow:Date=new Date();

var options = {

// filename:"Application.csv",
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
    console.log(JSON.stringify(application));
    this.applicationService.sendMsgtoOtherComponent(application);
    this.router.navigate(['/application/update-application']);
  }
  exportCsv(){
    const csvRows = [];
    console.log(this.AllData)
    var filename = "Application";
    // const headers = this.AllData[0];
    // console.log("headers****"+headers);
    // var  DEFAULTFILENAME = 'mycsv.csv';
    let dateNow:Date=new Date();
    console.log(dateNow.getDate().toString+" Date");
    console.log(dateNow.getDay().toString+" day");
    console.log(dateNow.getMonth().toString+ " month");
    console.log(dateNow.getFullYear().toString+" year");


    for (let index = 0; index < this.AllData.length; index++) {
      console.log(this.AllData[index].applicationId+"id");
      this.application[index]=this.AllData[index];
    //  this.application[index].applicationName=this.AllData[index].applicationName;
    //  this.application[index].applicationDescription=this.AllData[index].applicationDescription;
    //  this.application[index].isCloudable=this.AllData[index].isCloudable;
    //  this.application[index].MigrationPattern=this.AllData[index].MigrationPattern;
    //  this.application[index].cloudProvider=this.AllData[index].cloudProvider;
    //  this.application[index].isAssessment=this.AllData[index].isAssessment;
    //  this.application[index].isFinalize=this.AllData[index].isFinalize;
    //  this.application[index].isDeleted=this.AllData[index].isDeleted;
    //  this.application[index].isDeactivate=this.AllData[index].isDeactivate;
      
    }

    console.log(this.application);
    // for (let index = 0; index < this.application.length; index++) {
     
    //   console.log(this.application[index]);
    // }

    
    var options = {

      // filename:"Application.csv",
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
        console.log(data);
        //this.reloadData();
        //this.router.navigate(['/applictaion']);
        this.reloadData();
        //this.getData.CollectData();
      },
      error => console.log('ERROR: ' + error));
      // this.router.navigate(['/applictaion']);
  }

  resetApplication(formvalues){
    this.applicationService.resetApplication(formvalues)
    .subscribe();
  }

   reloadData() {
     this.applicationService.CollectData(this.clientNameValue);
   }
   
   ViewApplication(formvalues){
     this.applicationService.sendMsgtoOtherComponent(formvalues);
     console.log(formvalues);
    this.router.navigate(['/application/view-application']);
   }
   assessApplication(formvalues){
     console.log(JSON.stringify(formvalues));
     console.log(formvalues.applicationId)
    this.applicationService.sendMsgtoOtherComponent(formvalues);
     this.router.navigate(['/application/assesst-application']);

   }

   deactivate(formvalues){
     this.applicationService.deactivate(formvalues).subscribe();
   }
   
   somefunction()
   {
     console.log("sommmmmmmmmmmmmmmmmmmmmmm");
   }
}
