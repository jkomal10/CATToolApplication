import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestionsService } from '../../assessment-questions/assessment-questions.service';
import { Subject } from 'rxjs';
import { AssessmentQuestions } from '../../assessment-questions/Question'
import { AssesstApplicationService } from './assesst-application.service';
import { DataTablesModule } from 'angular-datatables';
import { Answers } from './Answers';
import { ApplicationService } from '../application.service';
import { IfStmt } from '@angular/compiler';
import { LocalStorageService } from '../../utility/service/localStorage.service';

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
  result =[];
  queId1 = 0;
  i = -1;
  application: any;
  UpdateAnswersData: any;
  clientIdValue: number;
  userType1: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  constructor(private router: Router, private assessmentService: AssesstApplicationService, private applicationService: ApplicationService, private myStorage: LocalStorageService) { }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true
    }; //67 51 changes

    this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.question.subscribe(data => {
      console.log("Assesssssssssssssssssssssssssss");
      this.application = data;
      console.log(JSON.stringify(this.application) + "aaaaaaaaaaaaaaaaaaaaaaaa");
    });
    console.log(this.application.isSaved);
    if (this.application.isSaved == 0) {
      this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result => {
        console.log("First questionnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        this.AllData = result ;
        this.dtTrigger.next();

      });
    }
    else {
      console.log("Secound questionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
      this.assessmentService.UpdateAnswers(this.application.applicationId).subscribe(result => {
        this.UpdateAnswersData = result;
      });

      this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result => { this.AllData = result ; });
    }
  }
  AssessApplicationRule() {
    console.log('rule decide');
    this.assessmentService.AllRuleCheck(this.application.applicationId).subscribe();
  }
  selectChange(args) {

    this.tempp[this.single] = args.target.options[args.target.selectedIndex].text;
    this.single++;

    console.log(this.tempp[0]+"ooooooooooooo");
    console.log(this.tempp[1]+"ooooooooooooo");
    console.log(this.tempp[2]+"ooooooooooooo");
      }
    isSelected(value: string): boolean {
     //this.resultvalue;
     console.log(this.result.indexOf(value)>0);
     console.log(this.result+"kooooooooooooooooooooooook^^^^^^^666");
      return false;
        // if (this.user)
        //   return this.user.roles.indexOf(value) >= 0;
        // else
        //   return false;
      }
      selectChangeHandler(optionnnnnn,event,id){
        console.log(event.target.checked);
       if(event.target.checked){
         console.log("inside if");
         this.result.push(optionnnnnn.optionText);
       }else{
         console.log("inside else");
        this.result.reduceRight(optionnnnnn.optionText);
       }
        console.log(this.result);
      }

  //  selectChangeHandler(optionnnnnn,event,id){
  //   // var queId1=0,i=-1;
  //   var text1; 
  //   if(event.target.checked)
  //   {
  //   console.log(id+"idddddddd"+this.queId1);  
   
  //      if(this.queId1 === id )
  //      {
         
  //       console.log(id);
        
  //       text1=optionnnnnn.optionText;
  //       var text2="";
  //     //  this.result=this.result+','+text1;
  //     this.result.push(text1);
  //       console.log(text1+"iiiiiiiiii");
  //       //console.log(text1+"iiiiiiiiii");
  //      //  this.theCheckbox[this.i]=this.result;
  //        console.log(this.i+"if");
  //        console.log('rrrrrrrrrrrrrrrrrrrrrrrrrrr'+this.result);
  //      }else{
  //        if(queId!=id)
  //        {
  //          this.result=null;
  //        }
  //      this.i++;
  //      this.result.push(optionnnnnn.optionText);
  //      //this.result=this.result+","+optionnnnnn.optionText;
  //       this.theCheckbox[this.i]=optionnnnnn.optionText;
  //       console.log("else"+this.i);
  //      }
  //      var queId=id;
  //      this.queId1=queId;
     
      
  //    } else{
  //     this.result.slice(1);

  //     }
  //     var queId = id;
  //     this.queId1 = queId;

     
  // }

  onSubmit() {
    alert("Do you want to save");
    this.submit();
  }

  submit() {
    for (let index = 0; index < this.AllData.length; index++) {
      //const element = this.AllData[index];
      console.log(this.application.applicationId + "appidddddddddddddddddd");
      let answer: Answers = new Answers();
      answer.applicationId = this.application.applicationId;
      answer.questionId = this.AllData[index].questionId;
      if (this.AllData[index].questionType == "Multiple Choice Multiple Answer") {
        //answer.answerText =this.selectChangeHandler() ;
        answer.answerText = this.theCheckbox[this.multi];
        this.multi++;
      } else {
        answer.answerText = this.tempp[this.singlee];
        console.log(answer.answerText + "lllllllllllll")
        this.singlee++;

      }
      answer.cloudAbility = 0;
      this.answers[index] = answer;
      console.log(JSON.stringify(answer));
    }
    console.log(JSON.stringify(this.answers[0]) + "jjjjjjjjjj");
    this.assessmentService.saveAssessApplication(this.answers).subscribe();
    this.userActive = localStorage.getItem('isUserActive');
    if (this.userActive == 'false') {
      this.router.navigate(['/user/user-role']);
    }
    else {
      this.router.navigate(['/application']);
    }
  };

  onSubmitUpdated() {
    for (let index = 0; index < this.AllData.length; index++) {
      //const element = this.AllData[index];
      console.log(this.application.applicationId + "appidddddddddddddddddd");
      let answer: Answers = new Answers();
      answer.applicationId = this.application.applicationId;
      answer.questionId = this.AllData[index].questionId;
      if (this.AllData[index].questionType == "Multiple Choice Multiple Answer") {
        //answer.answerText =this.selectChangeHandler() ;
        answer.answerText = this.theCheckbox[this.multi];
        this.multi++;
      } else {
        answer.answerText = this.tempp[this.singlee];
        console.log(answer.answerText + "lllllllllllll")
        this.singlee++;

      }
      answer.cloudAbility = 0;
      this.answers[index] = answer;
      console.log(JSON.stringify(answer));
    }
    console.log(JSON.stringify(this.answers[0]) + "jjjjjjjjjj");
    this.assessmentService.saveAssessApplicationUpdate(this.answers).subscribe();

  }


}
