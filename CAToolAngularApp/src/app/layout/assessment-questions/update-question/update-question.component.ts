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

  constructor(private assessmentQuestionsService : AssessmentQuestionsService ,public router: Router) { }
  assessmentQuestionData : string;
  ngOnInit() {
    this.assessmentQuestionsService.question.subscribe(data => {this.que= data;}); 
    this.question=this.que;
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
