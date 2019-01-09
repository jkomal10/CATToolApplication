import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';
import { MigrationRule } from '../MigrationRule';
import { CloudProviderRule } from '../CloudProviderRule';
import { QuestionOption } from '../Option';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.scss']
})
export class UpdateQuestionComponent implements OnInit {


  public questionList : AssessmentQuestions = new AssessmentQuestions(); 
  assessmentTypeForMigrationValue : boolean;
  assessmentTypeForCloudProvider : boolean;
  MigrationData : any = [];
  CloudProviderData : any = [];
  MigrationDataArray : any=[];
  CloudProviderDataArray : any=[];
  question = new AssessmentQuestions();
  updatedQuestion = new AssessmentQuestions();
  questionObject = new AssessmentQuestions();
  public questionUpdate : AssessmentQuestions = new AssessmentQuestions();
  que : any;
  submitted = false;
  numberOfOptions : number;
  optionsValues = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];
  Options : Array<number>=[10];
  OptionsArray : Array<String>=[];

  constructor(private assessmentQuestionsService : AssessmentQuestionsService ,public router: Router,private myStorage:LocalStorageService) { }
  
  ngOnInit() {
    this.assessmentQuestionsService.question.subscribe(data => {this.que= data;}); 
    this.question=this.que;
    console.log(this.que);
    this.numberOfOptions=0;
    let option =this.optionsValues;
   
    this.numberOfOptions=this.question.questionOption.length;
    for (let index = 0; index < this.numberOfOptions; index++) {
      this.OptionsArray[index]=this.question.questionOption[index].optionText;
    }
    this.selectChangeHandlerDefault(this.numberOfOptions); 
  }

  assessmentTypeForMigrationClick(event){
    
    this.assessmentTypeForMigrationValue=event.target.checked;
    this.assessmentQuestionsService.getMigrationData().subscribe(result => 
      {
          this.MigrationData = result ;
         
          for (let index = 0; index < this.MigrationData.length ; index++) {
          this.MigrationDataArray[index] = this.MigrationData[index].migrationPattern; 
      }
      });
  }

  assessmentTypeForCloudProviderClick(event){
    this.assessmentTypeForCloudProvider=event.target.checked;
    this.assessmentQuestionsService.getCloudProviderData().subscribe(result => 
      {
          this.CloudProviderData = result ;
          for (let index = 0; index < this.CloudProviderData.length ; index++) {
          this.CloudProviderDataArray[index] = this.CloudProviderData[index].cloudProviders; 
      }
      });
  }

  selectChangeHandlerDefault(value:number){
    this.numberOfOptions=value;
    for (let index = 1; index <= this.numberOfOptions ; index++) {
       this.Options[index] = index;
    }
  }

  selectChangeHandler(event:any){
    this.numberOfOptions=parseInt(event.target.value,10);
    
    for (let index = 1; index <= this.numberOfOptions ; index++) {
       this.Options[index] = index;
    }
  }

  updateQue(updatedQuestion) {
     this.questionObject=updatedQuestion;
     for (let index = 0; index < this.OptionsArray.length; index++) {
      var option : QuestionOption = new QuestionOption();
      option.optionText=this.OptionsArray[index];
    
      this.questionUpdate.questionOption[index]=option;
        
     }

     for (let index = 0; index < this.MigrationData.length; index++) {
       if(this.MigrationData[index].migrationPattern!=false)
       {
        var migration : MigrationRule = new MigrationRule();
        migration.migrationId=this.MigrationData[index].migrationId;
        migration.clientId=this.myStorage.getCurrentUserObject().clientId;
        migration.questionText=this.updatedQuestion.questionText;
        this.questionUpdate.migrationRule[index]=migration;
       
       }
       
     }
    
     for (let index = 0; index <  this.CloudProviderData.length; index++) {
      if(this.CloudProviderData[index].cloudProviders)
      {
       var cloudProvider : CloudProviderRule = new CloudProviderRule();
       cloudProvider.cloudProviderId=this.CloudProviderData[index].cloudProviderId;
       cloudProvider.questionText=this.updatedQuestion.questionText;
       cloudProvider.clientId=this.myStorage.getCurrentUserObject().clientId;
       this.questionUpdate.cloudProviderRules[index]=cloudProvider;
      }
    }
     
     
    //  this.questionUpdate.assessmentTypeForCloudable=this.updatedQuestion.assessmentTypeForCloudable;

     console.log(this.updatedQuestion.assessmentTypeForCloudable);
     if(this.updatedQuestion.assessmentTypeForCloudable)
     {
      this.questionUpdate.assessmentTypeForCloudable="true";
     }
     else
     {
      this.questionUpdate.assessmentTypeForCloudable=null;
     }

     console.log(this.questionUpdate.assessmentTypeForCloudable);
     this.questionUpdate.clientId=this.myStorage.getCurrentUserObject().clientId;
     if(this.updatedQuestion.assessmentTypeForCloudProvider)
     {
     this.questionUpdate.assessmentTypeForCloudProvider="true";
     }
     else
     {
       this.questionUpdate.assessmentTypeForCloudProvider=null;
       this.questionUpdate.cloudProviderRules = null;
     }
     console.log(this.questionUpdate.assessmentTypeForCloudProvider);
     if(this.updatedQuestion.assessmentTypeForMigration)
     {
      this.questionUpdate.assessmentTypeForMigration="true";
     }
     else
     {
      this.questionUpdate.assessmentTypeForMigration=null;
      this.questionUpdate.migrationRule=null;
     }
    //  this.questionUpdate.assessmentTypeForMigration=this.updatedQuestion.assessmentTypeForMigration;
    this.questionUpdate.createdBy=this.que.createdBy;
    this.questionUpdate.cteatedTime=this.que.cteatedTime;
     this.questionUpdate.modifiedBy=this.myStorage.getCurrentUserObject().userName;
     this.questionUpdate.questionDescription=this.updatedQuestion.questionDescription;
     this.questionUpdate.questionText=this.updatedQuestion.questionText;
     this.questionUpdate.questionDisplayOrder=this.updatedQuestion.questionDisplayOrder;
     this.questionUpdate.numberOfOption=this.updatedQuestion.numberOfOption;
     this.questionUpdate.questionType=this.updatedQuestion.questionType;
     this.questionUpdate.questionId=this.question.questionId;
     
    console.log(this.questionUpdate);
    this.assessmentQuestionsService.updateQuestions(this.questionUpdate).subscribe();
    // this.questionObject.modifiedBy=this.myStorage.getCurrentUserObject().userName;
    this.router.navigate(['/assessment-questions']);
  }
  
  onSubmit(formvalues){
    this.updatedQuestion=formvalues;
    // console.log(this.updatedQuestion);
    this.updateQue(this.updatedQuestion);
  }


  
}
