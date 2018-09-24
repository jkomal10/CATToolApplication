import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import{AddAssessmentQuestionsService} from './add-assessment-questions.service';

import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { Subject } from '../../../../node_modules/rxjs';
import { IUser } from '../assessment-questions/user';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-assessment-questions',
  templateUrl: './add-assessment-questions.component.html',
  styleUrls: ['./add-assessment-questions.component.scss']
})
export class AddAssessmentQuestionsComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any = [];

  public user;
  password : string = "pass";
  username : string = "user";
  temp : string = "test";
  constructor(private getData:AddAssessmentQuestionsService,public router: Router,private addAssessmentQuestionsService : AddAssessmentQuestionsService,private http: HttpClient) {}

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
 

  form(formValues) {
    console.log(formValues.questionText);
    this.temp = JSON.stringify(formValues);
    this.addAssessmentQuestionsService.save(formValues).subscribe(
      (data:any)=>{
        console.log('add assessment question body');
        console.log(data);
      }
    );
    //this.router.navigate(['/assessment-questions']); 
  }

}


