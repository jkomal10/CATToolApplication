import { Component, OnInit } from '@angular/core';
import { Question } from './Question';
import { AddAssessmentQuestionService } from './add-assessment-question.service';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {

  question: Question = new Question();
  submitted = false;

  constructor(private questionService: AddAssessmentQuestionService) { }

  ngOnInit() {
  }

  newQuestion(): void {
    this.submitted = false;
    this.question = new Question();
  }

  save() {
    this.questionService.createQuestion(this.question)
      .subscribe(data => console.log(data), error => console.log(error));
    this.question = new Question();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
