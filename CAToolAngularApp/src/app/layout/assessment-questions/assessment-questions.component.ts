import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { AssessmentQuestionsService } from './assessment-questions.service';
import { Subject } from '../../../../node_modules/rxjs';

class Person {
  id: number;
  first_name: string;
  last_name: string;
}

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

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  persons: Person[];
  AllData : any = [];
  constructor(private getData :AssessmentQuestionsService,public router: Router,private http: HttpClient) { 

  }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true};

    this.getData.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      }); 

  }

  importQuestions() {
       this.router.navigate(['/import-questions']);
       }

  addQuestions(formValues) {
    console.log(formValues.questionText+" && "+formValues.questionDescription);
        this.router.navigate(['/add-assessment-questions']);
        }

  }