import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { QuestionOption } from '../Option';
import { JsonpModule } from '@angular/http';
import { stringify } from '@angular/compiler/src/util';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { MigrationRule } from '../MigrationRule';
import { CloudProviderRule } from '../CloudProviderRule';

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
  optionsValues = [1, 2, 3,4,5,6,7,8,9];
  MigrationData : any = [];
  CloudProviderData : any = [];
  MigrationDataArray : any=[];
  CloudProviderDataArray : any=[];
  
  constructor(private questionService: AssessmentQuestionsService,public router: Router,private http: HttpClient) { }

  ngOnInit() {

  }

  selectChangeHandler(event:any){
    //console.log('rrrrrrrrrrrrrrrrr'+this.optionText[0]);
    console.log(event);
    this.numberOfOptions=parseInt(event.target.value,10);
   // this.numberOfOption=event;
   
    console.log(this.numberOfOptions);
    console.log(event.target.value);
 
    for (let index = 1; index <= this.numberOfOptions ; index++) {
      console.log(index);
       this.Options[index] = index;
       console.log(this.Options);
       console.log(this.Options.length);

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
          migration.questionText=this.question.questionText;
          this.question.migrationRule[index]=migration;
        }
      }
      for(let index = 0; index < this.CloudProviderData.length; index++){
        if(this.CloudProviderData[index].cloudProviders!=false){
          var cloudProvider : CloudProviderRule = new CloudProviderRule();
          cloudProvider.cloudProviderId=this.CloudProviderData[index].cloudProviderId;
          cloudProvider.questionText=this.question.questionText;
          this.question.cloudProviderRules[index]=cloudProvider;
        }
      }
      console.log(JSON.stringify(this.question));
      this.questionService.createQuestionn(this.question).subscribe(
      );
   }

  onSubmit() {   
    this.submitted = true
    this.save();
  }

  assessmentTypeForMigrationClick(event){
    console.log(event.target.checked);
    this.assessmentTypeForMigrationValue=event.target.checked;
    this.questionService.getMigrationData().subscribe(result => 
      {
          this.MigrationData = result ;
          console.log(this.MigrationData );
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
