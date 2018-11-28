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
  dtTrigger:  Subject<any>  =  new  Subject();
  AllData :  any;
  assessmentQuestions: object[];
  numberOfOption: Array<string> = [];
  theCheckboxOptions: Array<string> = [];
  theCheckbox: Array<string> = [];
  public tempp: Array<string> = [];
  answers: Array<Answers> = [];
  multi = 0;
  single = 0;
  singlee = 0;
  result = "";
  queId1 = 0;
  i = -1;
  application: any;
  UpdateAnswersData: any;
  clientIdValue: number;
  userType1: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  constructor(private myStorage: LocalStorageService, private router: Router, private assessmentService: AssesstApplicationService, private applicationService: ApplicationService) { }

  ngOnInit() {

    this.dtOptions  =  {
      pagingType:  'full_numbers',
      pageLength:  10,
      responsive:  true
    };
    this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.question.subscribe(data  => {
      this.application =  data;
    });
    if (this.application.isSaved == 0) {
      this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result  => {
        this.AllData  =  result ;
        this.dtTrigger.next();
      });
    }
    else {
      this.assessmentService.UpdateAnswers(this.application.applicationId).subscribe(result => {
      this.UpdateAnswersData = result;
      });

      this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result => { this.AllData  =  result ; });
    }
  }
  AssessApplicationRule() {
    console.log('rule decide');
    this.assessmentService.AllRuleCheck(this.application.applicationId).subscribe();
  }
  selectChange(args) {
    this.tempp[this.single] = args.target.options[args.target.selectedIndex].text;
    this.single++;
  }

  selectChangeHandler(optionnnnnn, event, id) {
    if (event.target.checked) {
      if (this.queId1 === id) {
        var text1 = optionnnnnn.optionText;
        var text2 = "";
        this.result = this.result + text1;
        this.theCheckbox[this.i] = this.result;
      } else {
        if (queId != id) {
          this.result = "";
        }
        this.i++;
        this.result = this.result + "," + optionnnnnn.optionText;
        this.theCheckbox[this.i] = optionnnnnn.optionText;
      }
      var queId = id;
      this.queId1 = queId;
    } else {

    }
  }

  onSubmit() {
    alert("Do you want to save");
    this.application.isSaved = 1;
    this.submit();
  }

  submit() {
    this.application.isSaved = 1;
    for (let index = 0; index < this.AllData.length; index++) {
      let answer: Answers = new Answers();
      answer.applicationId = this.application.applicationId;
      answer.questionId = this.AllData[index].questionId;
      if (this.AllData[index].questionType == "Multiple Choice Multiple Answer") {
        answer.answerText = this.theCheckbox[this.multi];
        this.multi++;
      } else {
        answer.answerText = this.tempp[this.singlee];
        this.singlee++;

      }
      answer.cloudAbility = 0;
      this.answers[index] = answer;
      console.log(JSON.stringify(answer));
    }
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
      let answer: Answers = new Answers();
      answer.applicationId = this.application.applicationId;
      answer.questionId = this.AllData[index].questionId;
      if (this.AllData[index].questionType == "Multiple Choice Multiple Answer") {
        answer.answerText = this.theCheckbox[this.multi];
        this.multi++;
      } else {
        answer.answerText = this.tempp[this.singlee];
        this.singlee++;

      }
      answer.cloudAbility = 0;
      this.answers[index] = answer;
    }
    this.assessmentService.saveAssessApplicationUpdate(this.answers).subscribe();

  }


}
