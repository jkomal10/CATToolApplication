import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import{AssessmentQuestionsService} from './assessment-questions.service';

@Component({
  selector: 'app-assessment-questions',
  templateUrl: './assessment-questions.component.html',
  styleUrls: ['./assessment-questions.component.scss']
})
export class AssessmentQuestionsComponent implements OnInit {
  public user;
  password : string = "pass";
  username : string = "user";
  constructor(public router: Router,private loginservice : AssessmentQuestionsService) {}

  ngOnInit() {}

  myFunction() {
    localStorage.setItem('isLoggedin', 'true');   
    this.router.navigate(['/add-assessment-questions']);
    console.log(this.username); 
  }
 

  form() {
    localStorage.setItem('isLoggedin', 'true');   
    this.router.navigate(['/import-questions']);
    console.log(this.username);   
  }

}


