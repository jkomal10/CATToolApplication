import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.scss']
})
export class UpdateQuestionComponent implements OnInit {

  question = new AssessmentQuestions();
  que : any;
  submitted = false;
  numberOfOptions : number;
  optionsValues = [1, 2, 3,4,5,6,7,8,9];
  Options : Array<number>=[10];

  constructor(private assessmentQuestionsService : AssessmentQuestionsService ,public router: Router) { }
  assessmentQuestionData : string;
  ngOnInit() {
    this.assessmentQuestionsService.question.subscribe(data => {this.que= data;}); 
    this.question=this.que;
    this.numberOfOptions=this.question.questionOption.length;
    console.log(JSON.stringify(this.question.questionOption.length));
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

  updateQue(question) {
    console.log('*******onsubmit application**********'+question.questionId);
    this.assessmentQuestionsService.updateAssessmentQuestions(question)
      .subscribe(
      );
      this.router.navigate(['/assessment-questions']);
  }
  
  onSubmit(formvalues){
    this.question=formvalues;
      this.updateQue(this.question);
  }


  
}
