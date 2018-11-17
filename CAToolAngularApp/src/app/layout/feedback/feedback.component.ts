import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  constructor(public router:Router) { }

  rating : number=0;

  ngOnInit() {
    this.rating=0;
  }

  oneStar(){
    console.log("One Star");
    this.rating=1;
  }

  twoStar(){
    this.rating=2;
    console.log("Two Star");
  }

  threeStar(){
    this.rating=3;
    console.log("Three Star");
  }

  fourStar(){
    this.rating=4;
    console.log("Four Star");
  }

  fiveStar(){
    this.rating=5;
    console.log("Five Star");
  }

}
