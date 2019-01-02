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

  clientIdValue:number;
  question: AssessmentQuestions = new AssessmentQuestions();
  questionId : number;
  submitted = false;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  assessmentQuestions:Array<AssessmentQuestions>=[]
  assessmentQuestionData: any = [];
  constructor(private assessmentQuestionsService :AssessmentQuestionsService,public router: Router,private http: HttpClient, private myStorage:LocalStorageService) { 

  }

  exportCsv(){
   var filename = "Assessment Question";
   for (let index = 0; index < this.assessmentQuestionData.length; index++) {
    this.assessmentQuestions[index]=this.assessmentQuestionData[index];
   }
   var options={
     headers:["questionId","questionText","questionDescription","questionType","questionDisplayOrder",
              "numberOfOption","isActive","isDelete","assessmentTypeForMigration","assessmentTypeForCloudProvider",
               "assessmentTypeForCloudable","createdBy","cteatedTime"]
   }
   new Angular5Csv(this.assessmentQuestions, filename, options);
  }

  ngOnInit() {

    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};

    this.assessmentQuestionsService.getAllQuestions(this.clientIdValue).subscribe(result => 
      {
        this.assessmentQuestionData= result ;
        this.dtTrigger.next();
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
     
  }

  updateQuestions(questions: AssessmentQuestions){
    this.assessmentQuestionsService.sendMsgtoOtherComponent(questions);
    this.router.navigate(['/assessment-questions/update-question']);
  }

  deactivate(){
    this.router.navigate(['/assessment-questions/update-question']);
  }
    
  }
