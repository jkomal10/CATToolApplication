import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assessment-questions',
  templateUrl: './assessment-questions.component.html',
  styleUrls: ['./assessment-questions.component.scss'],
})
export class AssessmentQuestionsComponent implements OnInit {
  password : string = "pass";
  username : string = "user";

  constructor(public router: Router) { }

  ngOnInit() {
  }

  onLoggedin() {
    console.log('add page');
    localStorage.setItem('isLoggedin', 'true');   
    if("pass"==this.password)
    {
       this.router.navigate(['/dashboard']);
       console.log(this.username);
    }    
   //  this.loginservice.getUserByID(formValues.username).subscribe((data) => {
   //     this.user = data;
   //     if(this.user.password != null){
   //         if(formValues.password == this.user.password){
   //             console.log(this.user.password);
   //             this.router.navigate(['/dashboard']);
   //         }
           else{
                alert("invalid Password");
           }
       }
       // else{
       //     alert("invalid UserName");
       // }});

   //this.router.navigate(['/dashboard']);
//}
}
