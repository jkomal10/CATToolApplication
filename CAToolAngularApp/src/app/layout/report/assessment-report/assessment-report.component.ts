import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ApplicationService } from '../../application/application.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';
@Component({
  selector: 'app-assessment-report',
  templateUrl: './assessment-report.component.html',
  styleUrls: ['./assessment-report.component.scss']
})
export class AssessmentReportComponent implements OnInit {
  toDate:Date;
  fromDate:Date;
  minDate:Date ; 
  maxDate:Date ;
  clientIdValue : number;
  applicationList: any = [];
  dropdownSelect:number=0;

  constructor(private applicationService:ApplicationService,private myStorage:LocalStorageService) { 
    this.minDate = new Date();
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() + 2);
    this.minDate.setFullYear(this.minDate.getFullYear() - 2);
    console.log(this.maxDate);
    console.log(this.minDate);
    
  }

  ngOnInit() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllFinalizeAplication(this.clientIdValue).subscribe(result => 
      {
      this.applicationList= result ;
      console.log(JSON.stringify(this.applicationList));
      });
  }

  submit(){
    console.log(this.fromDate);
    console.log(this.toDate);
  }

  getApplication(){
    this.dropdownSelect=1;
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.getAllFinalizeAplication(this.clientIdValue).subscribe(result => 
      {
      this.applicationList= result ;
      console.log(JSON.stringify(this.applicationList));
      });

    
  }

}
