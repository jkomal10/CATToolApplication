import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { Option } from '../Option';
import { JsonpModule } from '@angular/http';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {

  answerValues : string;
  Options : Array<number>=[10];
  //Options : number[];
  question: AssessmentQuestions = new AssessmentQuestions();
  option: Option = new Option();
  submitted = false;
  numberOfOptions : number;
  optionsValues = [1, 2, 3,4,5,6,7,8,9,10];
  
  
  constructor(private questionService: AssessmentQuestionsService,public router: Router) { }

  ngOnInit() {

   
  }

  selectChangeHandler(event:any){
    console.log(event);
    this.numberOfOptions=parseInt(event.target.value,10);
   // this.numberOfOption=event;
    console.log(this.numberOfOptions);
    console.log(event.target.value);
   // this.numberOfOption1 = Array.of(this.numberOfOptions);
    //console.log(this.numberOfOption1);
   // this.Options[event];
   //  console.log(this.Options);
    //console.log(this.Options);
    for (let index = 1; index <= this.numberOfOptions ; index++) {
      console.log(index);
       this.Options[index] = index;
       console.log(this.Options);
       console.log(this.Options.length);
    }
    // for (const key in event) {
    //   if (event.hasOwnProperty(key)) {
    //     const element = event[key];
    //     console.log(element)  ;
    //   }
    // }
    // console.log(this.Options);
  }

  options(){
    for (let index = 0; index < this.question.numberOfOption ; index++) {
      this.Options[index] = index; 
    }
  }

  newQuestion(): void {
    this.submitted = false;
    this.question = new AssessmentQuestions();
  }
    obj : JsonpModule;
    obj2 : JsonpModule;
   save() {
    this.option.assessmentQuestions=this.question;
    //console.log("**********************"+this.option.question+"***********");
    console.log(JSON.stringify(this.option));
    this.questionService.createOption(this.option).subscribe(
      
    );

    // this.questionService.createQuestion(this.option)
    //       .subscribe(data => console.log(data), error => console.log(error));
    //    this.option.question=this.question;
    //   //console.log(this.question.questionText+"***********");
    //   // console.log(this.option.optionText+"***********");
    //   console.log(this.option.question.questionText+"***********");
    //    this.router.navigate(['/assessment-questions']);
   }

  
 
  onSubmit() {

   
    this.submitted = true
    this.save();
  }

}
