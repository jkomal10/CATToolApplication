import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Subject } from 'rxjs';

import { AssesstApplicationService } from './assesst-application.service';


import { ApplicationService } from '../application.service';

import { LocalStorageService } from '../../utility/service/localStorage.service';
import { Answers } from './Answers';

import { UserRoleService } from '../../user/user-role/user-role.service';
@Component({
  selector: 'app-assesst-application',
  templateUrl: './assesst-application.component.html',
  styleUrls: ['./assesst-application.component.scss']
})
export class AssesstApplicationComponent implements OnInit {
  userActive: string;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any;
  assessmentQuestions: object[];
  numberOfOption: Array<string> = [];
  theCheckboxOptions: Array<string> = [];
  theCheckbox: Array<string> = [];
  public tempp: Array<string> = [];
  answers: Array<Answers> = [];
  multi = 0;
  single = 0;
  singlee = 0;
  result: any;
  queId1 = 0;
  qid = 0;
  opId=0;
  i = -1;
  All:any=[1,2,3,4,5,6,7];
  isChecked=false;
  
  application: any;
  AnswersData : any =[];
  clientIdValue: number;
  userType1: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  constructor( private router: Router, private assessmentService: AssesstApplicationService, private applicationService: ApplicationService, private myStorage: LocalStorageService, private userRoleService : UserRoleService ) { }

  ngOnInit() {
    
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true,
      columnDefs: [{ orderable: false, targets:3 }]
    };
    this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
    
    this.applicationService.question.subscribe(data => {
      this.application = data;
      });
      if(this.myStorage.getCurrentUserObject().isAdmin==1)
      {

        this.userRoleService.question.subscribe(data => {
          this.application = data;
          
        });
      }
    

      this.assessmentService.getAnswers(this.application.applicationId).subscribe(result => {
       
        this.AnswersData = result;
       
      });

    this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result => {
     
        this.AllData = result;
         });
      }
  onSelect(obj){
    let flag=0;
           for (let index = 0; index < this.AllData.length; index++) {
         for (let i= 0; i < this.AllData[index]['questionOption'].length; i++) {
          if(this.AllData[index]['questionOption'][i].optionId==obj){
              for (let j = 0; j < this.AnswersData.length; j++) {
                   if(this.AnswersData[j].questionId==this.AllData[index].questionId)
                   {
                    this.AnswersData[j].answerText= this.AllData[index]['questionOption'][i].optionText;
                    flag=1;
                     break; 
                  }
                }
              if(flag==0){
                let answer : Answers =new Answers();
                 answer.applicationId=this.application.applicationId;
                 answer.questionId=this.AllData[index].questionId;
                 answer.optionId=obj;
                 answer.answerText=this.AllData[index]['questionOption'][i].optionText;
                 this.AnswersData[this.opId]=answer;
                   this.opId++;
              }
         }

        }   
    }
  }

  save(){
        let ansCount = this.AnswersData.length;
    for (let index = 0; index < this.AllData.length; index++) {
      let flag=0
       for (let k = 0; k < this.AnswersData.length; k++) {
        if(this.AnswersData[k].questionId==this.AllData[index].questionId)
         {
           flag=1;
         }
       }
       if(flag==0){
        let answer : Answers =new Answers();
        answer.applicationId=this.application.applicationId;
        answer.questionId=this.AllData[index].questionId;
        answer.optionId=286;
        this.AnswersData[ansCount]=answer;
         ansCount++

       }
      
    }
     
    this.AnswersData.sort(function (questionOrder1, questionOrder2) {
    if (questionOrder1.questionId > questionOrder2.questionId) {
    return 1;
    }
    if (questionOrder1.questionId < questionOrder2.questionId) {
    return -1;
    }
    }); 
 

    this.assessmentService.saveAssessApplication(this.AnswersData).subscribe();
    if(this.myStorage.getCurrentUserObject().isAdmin==0){
      location.reload();
    this.router.navigate(['/application']);
     }else{
      location.reload();
      this.router.navigate(['/user/user-role']);
     }
    }
 
  onSubmit(formvalues){
       this.assessmentService.Update(this.AnswersData).subscribe();
       if(this.myStorage.getCurrentUserObject().isAdmin==0){
        location.reload();
        this.router.navigate(['/application']);
         }else{
          location.reload();
          this.router.navigate(['/user/user-role']);
         }
     }
    
     updateSelectedTimeslots(event) {
       for (let x = 0; x < this.AnswersData.length; x++) {
          if (event.target.checked) {
            if (this.AnswersData[x].optionId.indexOf(parseInt(event.target.name)) < 0) { 
              this.AnswersData[x].optionId.push(parseInt(event.target.name));
  
            }
       } else {
             if (this.AnswersData[x].optionId.indexOf(parseInt(event.target.name)) > -1) 
              {
                this.AnswersData[x].optionId.splice(this.AnswersData[x].optionId.indexOf(parseInt(event.target.name)), 1);              
              }
      }
        
      }  
  }
  selectChangeHandler(optionObject,event,qid){
     let flag=0;
         if(event.target.checked)
          {
            for (let x = 0; x < this.AnswersData.length; x++) 
              {
                if(this.AnswersData[x].questionId===qid){
                  this.AnswersData[x].answerText=this.AnswersData[x].answerText+","+optionObject.optionText;
                 flag=1;
                               }
              }
             if(flag==0){
              let answer : Answers =new Answers();
              answer.applicationId=this.application.applicationId;
              answer.questionId=qid;
              answer.optionId=optionObject.optionId;
              answer.answerText=optionObject.optionText;
              this.AnswersData[this.opId]=answer;
                this.opId++;
             }
              

            }else{
              for (let x = 0; x < this.AnswersData.length; x++) 
              {
                if(this.AnswersData[x].questionId===qid){
                  this.AnswersData[x].answerText=this.AnswersData[x].answerText.replace(optionObject.optionText+",",'');
                 
                }
              }

            }

      }


      finalise(){

        this.assessmentService.AllRuleCheck(this.application.applicationId).subscribe();
        location.reload();
      }

}
