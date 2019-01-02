import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Feedback } from './Feedback';
import { FeedbackService } from './feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  
  feedbackObject: Feedback = new Feedback();
  question1 : string;
  question2 : string;
  question3 : string;
  recommend : string;
  other : string;
  rating : number=0;

  constructor(public router:Router,private feedbackService: FeedbackService) { }

  ngOnInit() {
    this.rating=0;
  }

  oneStar(){

    this.rating=1;
  }

  twoStar(){
    this.rating=2;
    
  }

  threeStar(){
    this.rating=3;
    
  }

  fourStar(){
    this.rating=4;
   
  }

  fiveStar(){
    this.rating=5;
    
  }

  feedback(){
    this.feedbackObject.question1=this.question1;
    this.feedbackObject.question2=this.question2;
    this.feedbackObject.question3=this.question3;
    this.feedbackObject.recommend=this.recommend;
    this.feedbackObject.rating=this.rating;
    this.feedbackService.addFeedback(this.feedbackObject).subscribe();
    this.router.navigate(['/dashboard']);
  }

}
