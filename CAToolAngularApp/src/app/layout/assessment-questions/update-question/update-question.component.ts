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
  assessmentQuestionData : string;
  ngOnInit() {
    this.assessmentQuestionsService.question.subscribe(data => {this.que= data;}); 
    this.question=this.que;
    console.log("**********"+this.question.questionId);
    this.numberOfOptions=0;
    let option =this.optionsValues;
    this.numberOfOptions=this.question.questionOption.length;
    console.log(this.question.questionOption[0].optionText+"))))))");
    for (let index = 0; index < this.numberOfOptions; index++) {
      this.OptionsArray[index]=this.question.questionOption[index].optionText;
    }
    // this.OptionsArray[0]=this.question.questionOption[0].optionText;
    this.selectChangeHandlerDefault(this.numberOfOptions);
    console.log(JSON.stringify(this.question.questionOption));
    
  }

  assessmentTypeForMigrationClick(event){
    console.log(event.target.checked);
    this.assessmentTypeForMigrationValue=event.target.checked;
    this.assessmentQuestionsService.getMigrationData().subscribe(result => 
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
    this.assessmentQuestionsService.getCloudProviderData().subscribe(result => 
      {
          this.CloudProviderData = result ;
          for (let index = 0; index < this.CloudProviderData.length ; index++) {
          this.CloudProviderDataArray[index] = this.CloudProviderData[index].cloudProviders; 
      }
      });
  }

  selectChangeHandlerDefault(value:number){
    
    console.log("option value "+value); 
    this.numberOfOptions=value;
   
    console.log(this.numberOfOptions);
    console.log();
    
    for (let index = 1; index <= this.numberOfOptions ; index++) {
      console.log(index);
       this.Options[index] = index;
       console.log(this.Options);
       console.log(this.Options.length);
    }
  }

  selectChangeHandler(event:any){
    console.log(event.target.value+"********");
    this.numberOfOptions=parseInt(event.target.value,10);
   
    console.log(this.numberOfOptions);
    console.log(event.target.value);
    
    for (let index = 1; index <= this.numberOfOptions ; index++) {
      console.log(index);
       this.Options[index] = index;
       console.log(this.Options);
       console.log(this.Options.length);
    }
  }

  updateQue(updatedQuestion) {
    // console.log('&&&&&&&&&&&'+question);
    console.log('*******onsubmit application**********'+this.question.questionId);
    this.questionObject=updatedQuestion;
    // console.log("&&&&&&&&&"+this.myStorage.getCurrentUser());
    this.questionObject.modifiedBy="UUUUUUUUU";
    console.log("%%%%%%%%5",updatedQuestion);
    // this.assessmentQuestionsService.updateAssessmentQuestions(updatedQuestion)
    //   .subscribe(
    //   );
      this.router.navigate(['/assessment-questions']);
  }
  
  onSubmit(formvalues){
    this.updatedQuestion=formvalues;
    console.log("%%%%%%%%5",this.updatedQuestion);
      this.updateQue(this.updatedQuestion);
  }


  
}
