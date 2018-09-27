import { Component, OnInit, Input } from '@angular/core';
import { UpdateQuestionService } from './update-question.service';
import { Question } from './Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.scss']
})
export class UpdateQuestionComponent implements OnInit {

  constructor(private customerService: UpdateQuestionService,private assessmentQuestionsService : AssessmentQuestionsService ) { }
  assessmentQuestionData : string;
  ngOnInit() {
      this.assessmentQuestionsService.question.subscribe(data => this.assessmentQuestionData = data);
  }
  
}
