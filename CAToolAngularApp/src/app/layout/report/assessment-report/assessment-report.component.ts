import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../application/application.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';
import { AssessmentReportService } from './assessment-report.service';
@Component({
  selector: 'app-assessment-report',
  templateUrl: './assessment-report.component.html',
  styleUrls: ['./assessment-report.component.scss']
})
export class AssessmentReportComponent implements OnInit {
  toDate:Date=null;
  fromDate:Date=null;
  minDate:Date ; 
  maxDate:Date ;
  clientIdValue : number;
  applicationList: any = [];
  dropdownSelect:boolean;
  genereteAppReport:string;
  appIds:string;
  applications:any;
  viewClick:boolean=false;
  viewAllReports:any=[];
  constructor(private applicationService:ApplicationService,private myStorage:LocalStorageService,private assessmentReportService:AssessmentReportService) { 
    this.minDate = new Date();
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() + 2);
    this.minDate.setFullYear(this.minDate.getFullYear() - 2);
    
  }

  
  selectedAppIds(value:any)
  {
    this.appIds = this.appIds+","+value;
  }

  ngOnInit() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
  }

  submit(formValues:any){
    console.log(this.genereteAppReport);
  }

  getApplication(){
    if((this.fromDate==null || this.toDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
    else{
      this.dropdownSelect=true;
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllFinalizeAplication(this.clientIdValue,this.fromDate,this.toDate).subscribe(result => 
      {
      this.applicationList= result ;
      });
    }
    
  }

  
  generateReport(){
    this.dropdownSelect=false;
    if((this.fromDate==null || this.toDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
  if(this.appIds==null)
  {
    alert("Please select Application Name for which you want to generate report date");
  }
    this.applications=this.appIds.split(",");
    
    this.assessmentReportService.generateReport(this.appIds).subscribe(result => this.applications= result);
  }
  ViewReport()
  {
    this.dropdownSelect=false;
    if((this.fromDate==null || this.toDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
  else{
    this.viewClick=true;
    this.assessmentReportService.viewGeneratedReport(this.fromDate,this.toDate).subscribe(result=>{this.viewAllReports=result,console.log(this.viewAllReports)});
  }
  }

  generatePDFview(applicationName:string){
    
    this.assessmentReportService.viewReportInBrowser(applicationName).subscribe((response)=>{
         let file = new Blob([response], { type: 'application/pdf' });
         var fileURL = URL.createObjectURL(file);
         window.open(fileURL);
      });
  }

  zipExport()
  {
    if((this.fromDate==null || this.toDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
  else{
    this.assessmentReportService.zipExport(this.fromDate,this.toDate).subscribe();
  }
  }

}
