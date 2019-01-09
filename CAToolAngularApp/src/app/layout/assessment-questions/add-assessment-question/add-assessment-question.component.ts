import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { QuestionOption } from '../Option';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { MigrationRule } from '../MigrationRule';
import { CloudProviderRule } from '../CloudProviderRule';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {
  assessmentTypeForMigrationValue : boolean;
  assessmentTypeForCloudProvider : boolean;
  answerValues : string;
  value : string
  optionText : Array<string>=[];
  Options : Array<number>=[10];
 
 public question : AssessmentQuestions = new AssessmentQuestions(); 
 public optionList : Array<QuestionOption>=[];
  submitted = false;
  numberOfOptions : number;
  optionsValues = [0,1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21];
  MigrationData : any = [];
  CloudProviderData : any = [];
  MigrationDataArray : any=[];
  CloudProviderDataArray : any=[];
  clientIdValue : number;
  
  constructor(private questionService: AssessmentQuestionsService,public router: Router,private http: HttpClient,private myStorage:LocalStorageService) { }

  ngOnInit() {
      this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
  }

  selectChangeHandler(event:any){
    this.numberOfOptions=parseInt(event.target.value,10);

    for (let index = 1; index <= this.numberOfOptions ; index++) {
       this.Options[index] = index;
    }
  }

  options(){
    for (let index = 0; index < this.question.numberOfOption ; index++) {
      this.Options[index] = index; 
    }
  }

  newQuestion(): void {
    this.submitted = false;
    this.question = new AssessmentQuestions();
  }
    save() {
       for (let index = 0; index < this.optionText.length; index++) {
         var option : QuestionOption = new QuestionOption();
         option.optionText=this.optionText[index];
       
         this.question.questionOption[index]=option;
       
      }
      for(let index = 0; index < this.MigrationData.length; index++){
        if(this.MigrationData[index].migrationPattern!=false){
          var migration : MigrationRule = new MigrationRule();
          migration.migrationId=this.MigrationData[index].migrationId;
          migration.clientId=this.myStorage.getCurrentUserObject().clientId;
          migration.questionText=this.question.questionText;
          this.question.migrationRule[index]=migration;
        }
      }
      for(let index = 0; index < this.CloudProviderData.length; index++){
        if(this.CloudProviderData[index].cloudProviders!=false){
          var cloudProvider : CloudProviderRule = new CloudProviderRule();
          cloudProvider.cloudProviderId=this.CloudProviderData[index].cloudProviderId;
          cloudProvider.questionText=this.question.questionText;
          cloudProvider.clientId=this.myStorage.getCurrentUserObject().clientId;
          this.question.cloudProviderRules[index]=cloudProvider;
        }
      }
      this.question.clientId=this.myStorage.getCurrentUserObject().clientId;
      this.question.createdBy=this.myStorage.getCurrentUserObject().userName;
    
      this.questionService.createQuestionn(this.question).subscribe(
      );
      location.reload();
      this.router.navigate(['/assessment-questions']);
   }

  onSubmit() {   
    this.submitted = true
    this.save();
  }

  assessmentTypeForMigrationClick(event){
   
    this.assessmentTypeForMigrationValue=event.target.checked;
    this.questionService.getMigrationData().subscribe(result => 
      {
          this.MigrationData = result ;
          for (let index = 0; index < this.MigrationData.length ; index++) {
          this.MigrationDataArray[index] = this.MigrationData[index].migrationPattern; 
      }
      });
  }

  assessmentTypeForCloudProviderClick(event){
    this.assessmentTypeForCloudProvider=event.target.checked;
    this.questionService.getCloudProviderData().subscribe(result => 
      {
          this.CloudProviderData = result ;
          for (let index = 0; index < this.CloudProviderData.length ; index++) {
          this.CloudProviderDataArray[index] = this.CloudProviderData[index].cloudProviders; 
      }
      });
  }

}
