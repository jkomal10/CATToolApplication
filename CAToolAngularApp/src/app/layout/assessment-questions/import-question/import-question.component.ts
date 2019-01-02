import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';

@Component({
  selector: 'app-import-question',
  templateUrl: './import-question.component.html',
  styleUrls: ['./import-question.component.scss']
})
export class ImportQuestionComponent implements OnInit {

  filename : any;
  link : any;
  ext : string ;
  extCheck : boolean =  false;
  extation : string = ".csv";
  AssessmentQuestions : AssessmentQuestions = new AssessmentQuestions();
  AssessmentQuestion : AssessmentQuestions = new AssessmentQuestions();
  lines = [];
  ipAddress : any;
  constructor(public router: Router,private assessmentQuestionsService : AssessmentQuestionsService) { }

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
          this.AssessmentQuestions =  this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);
            
        }
    }

    else{
      alert("please enter a csv file");
    }
        
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
   
      this.AssessmentQuestion.questionId = this.lines[i][0];
      this.AssessmentQuestion.assessmentTypeForCloudProvider = this.lines[i][1];
      this.AssessmentQuestion.assessmentTypeForCloudable =this.lines[i][2];
      this.AssessmentQuestion.assessmentTypeForMigration =this.lines[i][3];
      this.AssessmentQuestion.createdBy = this.lines[i][4];
      this.AssessmentQuestion.cteatedTime =this.lines[i][5];
      this.AssessmentQuestion.isActive =this.lines[i][6];
      this.AssessmentQuestion.isDelete =this.lines[i][7];
      this.AssessmentQuestion.modifiedBy =this.lines[i][8];
      this.AssessmentQuestion.modifiedTime = this.lines[i][9];
      this.AssessmentQuestion.numberOfOption =this.lines[i][10];
      this.AssessmentQuestion.questionDescription =this.lines[i][11];
      this.AssessmentQuestion.questionDisplayOrder = this.lines[i][12];
      this.AssessmentQuestion.questionText =this.lines[i][13];
      this.AssessmentQuestion.questionType = this.lines[i][14];

     
      this.assessmentQuestionsService.createQuestionn(this.AssessmentQuestion)
    .subscribe(data => console.log(data), error => console.log(error));
    console.log("success");
    this.router.navigate(['/assessment-questions']);
    }
   }

}
