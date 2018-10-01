import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {

  question: Question = new Question();
  submitted = false;

  constructor(private questionService: AssessmentQuestionsService,public router: Router) { }

  ngOnInit() {
  }

  newQuestion(): void {
    this.submitted = false;
    this.question = new Question();
  }

  save() {
    this.questionService.createQuestion(this.question)
      .subscribe(data => console.log(data), error => console.log(error));
      this.router.navigate(['/assessment-questions']);
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
