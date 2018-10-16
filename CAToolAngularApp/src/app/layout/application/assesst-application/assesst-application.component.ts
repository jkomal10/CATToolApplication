import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestionsService } from '../../assessment-questions/assessment-questions.service';
import { Subject } from 'rxjs';
import { Question } from './Question';
import { AssesstApplicationService } from './assesst-application.service';

@Component({
  selector: 'app-assesst-application',
  templateUrl: './assesst-application.component.html',
  styleUrls: ['./assesst-application.component.scss']
})
export class AssesstApplicationComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any;
  assessmentQuestions : object [];
  numberOfOption : Array<string>=[];
  theCheckboxOptions : Array<string>=[];
  theCheckbox : Array<string> = new Array<string>();
  temp : Array<string>=[];
  constructor(private router:Router,private assessmentService:AssesstApplicationService) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true}; 

   this.assessmentService.CollecOptiontData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      
      console.log(this.AllData[0].optionText);
      console.log(this.AllData[1].optionText);
      console.log(this.AllData[0].assessmentQuestions.questionType);
      console.log(this.AllData[0].assessmentQuestions.questionText);
      

      });
      console.log(this.numberOfOption);
      console.log(this.theCheckboxOptions);
   } 
   selectChangeHandler(event: any,index : any){
   
    this.theCheckbox[index] = event;
        console.log(this.theCheckbox);
    // this.theCheckboxOptions = event;
    // console.log("this.theCheckboxOptions"+this.theCheckboxOptions[0]);
    console.log(event);
   }
   

}
