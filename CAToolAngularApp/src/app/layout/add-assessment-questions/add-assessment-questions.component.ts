import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import{AddAssessmentQuestionsService} from './add-assessment-questions.service';

@Component({
  selector: 'app-assessment-questions',
  templateUrl: './add-assessment-questions.component.html',
  styleUrls: ['./add-assessment-questions.component.scss']
})
export class AddAssessmentQuestionsComponent implements OnInit {
  public user;
  password : string = "pass";
  username : string = "user";
  constructor(public router: Router,private loginservice : AddAssessmentQuestionsService) {}

  ngOnInit() {}

  myFunction() {
    localStorage.setItem('isLoggedin', 'true');   
    this.router.navigate(['/add-assessment-questions']);
    console.log(this.username); 
  }
 

  form(formValues) {
    localStorage.setItem('isLoggedin', 'true');  
    console.log(formValues.numberOfOptions+" && "+formValues.password); 
    this.router.navigate(['/assessment-questions']);
    console.log(this.username);   
  }

}


