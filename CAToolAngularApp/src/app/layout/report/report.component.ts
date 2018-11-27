import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';
import { Application } from '../application/Application';
import { ApplicationService } from '../application/application.service';
import { ReportService } from './report.service';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  application:Array<Application>=[];
  AllData : any = [];
  clientIdValue : number;
  constructor(public router:Router, private applicationService:ApplicationService,private http:HttpClient, private reportService:ReportService,private myStorage:LocalStorageService) { }

  ngOnInit() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllAplication(this.clientIdValue).subscribe(result => 
      {
        this.AllData = result;
      });
  }

  summaryReport(){
    this.reportService.summaryReport().subscribe();
  }

  exportCsv(){
    const csvRows = [];
    var filename = "Application";
    let dateNow:Date=new Date();
    for (let index = 0; index < this.AllData.length; index++) {
      console.log(this.AllData[index].applicationId+"id");
      this.application[index]=this.AllData[index];  
    }

    console.log(this.application);
    var options = {
      headers:["ApplicationId","Application Name","Application Description","IsCloudable","MigrationPattern",
              "CloudProvider","IsAssessment","IsFinalized","IsDeleted","IsDeactivated","DeleteDateAndTime",
               "Isverified","CreatedDate","ModifiedDateTime","CreatedBy","ModifiedBy","UserId","IsSaved"]
    };
   new Angular5Csv(this.application, filename, options);
  }
}
