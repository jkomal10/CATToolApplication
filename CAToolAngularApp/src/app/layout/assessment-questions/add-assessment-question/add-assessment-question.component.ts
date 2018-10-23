import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { QuestionOption } from '../Option';
import { JsonpModule } from '@angular/http';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {

  answerValues : string;
  value : string
  optionText : Array<string>=[];
  Options : Array<number>=[10];
 
 public question : AssessmentQuestions = new AssessmentQuestions(); 
 public optionList : Array<QuestionOption>=[];
  submitted = false;
  numberOfOptions : number;
  optionsValues = [0,1, 2, 3,4,5,6,7,8,9];
  
  
  constructor(private questionService: AssessmentQuestionsService,public router: Router) { }

  ngOnInit() {

   
  }

  selectChangeHandler(event:any){
    //console.log('rrrrrrrrrrrrrrrrr'+this.optionText[0]);
    console.log(event);
    this.numberOfOptions=parseInt(event.target.value,10);
   // this.numberOfOption=event;
   
    console.log(this.numberOfOptions);
    console.log(event.target.value);
 
    for (let index = 1; index <= this.numberOfOptions ; index++) {
      console.log(index);
       this.Options[index] = index;
       console.log(this.Options);
       console.log(this.Options.length);

    }
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
    save() {
       for (let index = 0; index < this.optionText.length; index++) {
         console.log(this.optionText[index]+"option text original")
         var option : QuestionOption = new QuestionOption();
         option.optionText=this.optionText[index];
         this.question.questionOption[index]=option;
      }
      console.log(this.question.questionOption[0].optionText+"option text of zero position");
      // console.log(this.question.questionOption[1].optionText+"option text of zero position");
      console.log(JSON.stringify(this.question)+"component add questions ************");
       this.questionService.createQuestionn(this.question).subscribe(
      );
   }

  
 
  onSubmit() {

   
    this.submitted = true
    this.save();
  }

}
