import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
  appIds:string="";
  applications:any;
  viewClick:boolean=false;
  viewAllReports:any=[];
  constructor(private applicationService:ApplicationService,private myStorage:LocalStorageService,private assessmentReportService:AssessmentReportService) { 
    this.minDate = new Date();
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() + 2);
    this.minDate.setFullYear(this.minDate.getFullYear() - 2);
    // console.log(this.maxDate);
    // console.log(this.minDate);
    
  }

  
  selectedAppIds(value:any)
  {
    this.appIds = this.appIds+","+value;
    console.log(this.appIds);
  }

  ngOnInit() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllFinalizeAplication(this.clientIdValue).subscribe(result => 
      {
      this.applicationList= result ;
      // console.log(JSON.stringify(this.applicationList));
      });
  }

  submit(formValues:any){
    // console.log(formValues);
    console.log(this.genereteAppReport);
    // console.log(this.toDate);
  }

  getApplication(){
    if((this.fromDate==null || this.fromDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
    else{
      this.dropdownSelect=true;
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllFinalizeAplication(this.clientIdValue).subscribe(result => 
      {
      this.applicationList= result ;
      // console.log(JSON.stringify(this.applicationList));
      });
    }
    
  }

  
  generateReport(){
    this.dropdownSelect=false;
    if((this.fromDate==null || this.fromDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
    console.log(this.appIds);
    this.applications=this.appIds.split(",");
    console.log(this.applications);
    
    this.assessmentReportService.generateReport(this.appIds).subscribe(result => this.applications= result);
    // console.log(this.applications);
  }
  ViewReport()
  {
    //    this.assessmentReportService.viewReport(this.appIds).subscribe((response)=>{
    //    let file = new Blob([response], { type: 'application/pdf' });
    //    var fileURL = URL.createObjectURL(file);
    //    window.open(fileURL);
    // });
    this.dropdownSelect=false;
    if((this.fromDate==null || this.fromDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
  else{
    this.viewClick=true;
    this.assessmentReportService.viewGeneratedReport(this.fromDate,this.toDate).subscribe(result=>{this.viewAllReports=result,console.log(this.viewAllReports)});
    console.log(this.viewAllReports)
  }
  }

  generatePDFview(applicationName:string){
    console.log(applicationName);
    this.assessmentReportService.viewReportInBrowser(applicationName).subscribe((response)=>{
         let file = new Blob([response], { type: 'application/pdf' });
         var fileURL = URL.createObjectURL(file);
         window.open(fileURL);
      });
  }

  zipExport()
  {
    if((this.fromDate==null || this.fromDate==null) || this.fromDate>this.toDate)
    {
      alert("Please select Valid date");
  }
  else{
    this.assessmentReportService.zipExport(this.fromDate,this.toDate).subscribe();
  }
  }

}
