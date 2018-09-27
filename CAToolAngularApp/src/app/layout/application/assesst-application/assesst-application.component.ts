import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestionsService } from '../../assessment-questions/assessment-questions.service';

@Component({
  selector: 'app-assesst-application',
  templateUrl: './assesst-application.component.html',
  styleUrls: ['./assesst-application.component.scss']
})
export class AssesstApplicationComponent implements OnInit {

  AllData : any = [];
  constructor(private router:Router,private questionService:AssessmentQuestionsService) { }

  ngOnInit() {
  //   this.questionService.CollectQuestion().subscribe(result => 
  //     {
  //     this.AllData = result ;
     
  //     console.log(this.AllData);
  //     });
   } // this.dtTrigger.next();

}
