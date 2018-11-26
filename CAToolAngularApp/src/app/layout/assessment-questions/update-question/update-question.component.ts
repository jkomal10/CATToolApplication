import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestions } from '../Question';
import { AssessmentQuestionsService } from '../assessment-questions.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';

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
  que : any;
  submitted = false;
  numberOfOptions : number;
  optionsValues = [1,2,3,4,5,6,7,8,9];
  Options : Array<number>=[10];
  OptionsArray : Array<String>=[];

  constructor(private assessmentQuestionsService : AssessmentQuestionsService ,public router: Router,private myStorage:LocalStorageService) { }
  
  ngOnInit() {
    this.assessmentQuestionsService.question.subscribe(data => {this.que= data;}); 
    this.question=this.que;
    this.numberOfOptions=0;
    let option =this.optionsValues;
    this.numberOfOptions=this.question.questionOption.length;
    for (let index = 0; index < this.numberOfOptions; index++) {
      this.OptionsArray[index]=this.question.questionOption[index].optionText;
    }
    this.selectChangeHandlerDefault(this.numberOfOptions); 
  }

  assessmentTypeForMigrationClick(event){
    console.log(event.target.checked);
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
    this.questionObject.modifiedBy=this.myStorage.getCurrentUserObject().userName;
    this.router.navigate(['/assessment-questions']);
  }
  
  onSubmit(formvalues){
    this.updatedQuestion=formvalues;
    this.updateQue(this.updatedQuestion);
  }


  
}
