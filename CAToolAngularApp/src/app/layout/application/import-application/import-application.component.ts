import { Component, OnInit } from '@angular/core';
import { Application } from '../../decision-tree/reassessment/Application';
import { ApplicationService } from '../application.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-import-application',
  templateUrl: './import-application.component.html',
  styleUrls: ['./import-application.component.scss']
})
export class ImportApplicationComponent implements OnInit {
  filename : any;
  link : any;
  ext : string ;
  extCheck : boolean =  false;
  extation : string = ".csv";
   applications : Application = new Application();
  application : Application = new Application();
  lines = [];
  ipAddress : any;
  constructor(public router: Router,private applicationService : ApplicationService) { }

  ngOnInit() {
  }
  fileChangeListener(event:any){
    this.filename = event.target.files[0].name;
    this.link = event.target.files[0];
    this.ext = this.filename.substring(this.filename.lastIndexOf('.')).toLowerCase();

    if (this.isCSVFile(this.ext)){
      let reader: FileReader = new FileReader();
        reader.readAsText(this.link);
        reader.onload = (data) => {
          let csvData : string = reader.result;
          let csvRecordsArray = csvData.split(/\r|\n|\n/);
          let headersRow = this.getHeaderArray(csvRecordsArray);
          this.applications =  this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);
            
        }
    }

    else{
      alert("please enter a csv file");
    }
        console.log(this.filename[0]+"___________");
        console.log(this.link+"**************");
  }

  getDataRecordsArrayFromCSVFile(csvRecordsArray : any,headerLength : any){

    for (let i = 1; i < csvRecordsArray.length; i++) {
      let data = csvRecordsArray[i].split(',');
      if (data.length == headerLength) {
        var dataArr = [];
        for (let j = 0; j < headerLength; j++) {
          dataArr.push(data[j]);
      }
        
         this.lines.push(dataArr);
      }
    }
    console.log(this.lines.length);
    for (var i = 0; i < this.lines.length; i++)
      {
        
      console.log("adduser of row"+this.lines[i][0]);
      }
    return null;
  }

  getHeaderArray(csvRecordsArr : any){
    let headers = csvRecordsArr[0].split(',');
    let headerArray = [];
    for (let j = 0; j < headers.length; j++) {
    headerArray.push(headers[j]);
    }
   return headerArray;
  }

  isCSVFile(extn: string) {
    this.extCheck = (extn === this.extation);
    return this.extCheck;
    }

  importData(){


    for (var i = 0; i < this.lines.length; i++)
    {
   
      this.application.applicationId = this.lines[i][0];
      this.application.applicationName =this.lines[i][1];
      this.application.applicationDescription =this.lines[i][2];
      this.application.applicationType = this.lines[i][3];

      console.log("this.lines[i][0]"+this.lines[i][0]);
      console.log("this.lines[i][1]"+this.lines[i][1]);
      console.log("this.lines[i][2]"+this.lines[i][2]);
      console.log("this.lines[i][3]"+this.lines[i][3]);
      this.applicationService.createApplication(this.application)
    .subscribe();
    console.log("success");
    this.router.navigate(['/user']);
    console.log("----------this.userDetail"+this.application);
    }
    console.log("this.userDetail"+this.application);
   }

}
