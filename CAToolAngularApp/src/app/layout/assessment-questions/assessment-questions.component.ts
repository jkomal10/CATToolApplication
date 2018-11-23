import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { AssessmentQuestionsService } from './assessment-questions.service';
import { Subject } from 'rxjs';
import { AssessmentQuestions } from './Question';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';
import { LocalStorageService } from '../utility/service/localStorage.service';
class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-assessment-questions',
  templateUrl: './assessment-questions.component.html',
  styleUrls: ['./assessment-questions.component.scss']
})
export class AssessmentQuestionsComponent implements OnInit {

  clientNameValue:string;
  question: AssessmentQuestions = new AssessmentQuestions();
  questionId : number;
  submitted = false;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  assessmentQuestions:Array<AssessmentQuestions>=[]
 
  AllData : any = [];
  constructor(private assessmentQuestionsService :AssessmentQuestionsService,public router: Router,private http: HttpClient, private myStorage:LocalStorageService) { 

  }

  exportCsv(){
   var filename = "Assessment Question";
   for (let index = 0; index < this.AllData.length; index++) {
    this.assessmentQuestions[index]=this.AllData[index];
   }
   var options={
     headers:["questionId","questionText","questionDescription","questionType","questionDisplayOrder",
              "numberOfOption","isActive","isDelete","assessmentTypeForMigration","assessmentTypeForCloudProvider",
               "assessmentTypeForCloudable","createdBy","cteatedTime"]
   }
   new Angular5Csv(this.assessmentQuestions, filename, options);
  }

  ngOnInit() {

    this.clientNameValue=this.myStorage.getClient();

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};

    this.assessmentQuestionsService.getAllQuestions(this.clientNameValue).subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      }); 

  }

  importQuestions() {
       this.router.navigate(['/assessment-questions/import-question']);
       }

  addQuestions() {
        this.router.navigate(['/assessment-questions/add-assessment-question']);
        }

  deleteQuestions(formvalues) {
    this.assessmentQuestionsService.deleteQuestion(formvalues)
    .subscribe(
      data => {
        console.log(data);
      },
      error => console.log('ERROR: ' + error));
      this.router.navigate(['/assessment-questions']);
  }

  updateQuestions(questions: AssessmentQuestions){
    this.assessmentQuestionsService.sendMsgtoOtherComponent(questions);
    this.router.navigate(['/assessment-questions/update-question']);
  }

  deactivate(){
    this.router.navigate(['/assessment-questions/update-question']);
  }
    
  }
