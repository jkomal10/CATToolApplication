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
  result: any = [];
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
    };

    this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
    this.applicationService.question.subscribe(data => {
      this.application = data;
    });
    console.log(this.application.isSaved);
    if (this.application.isSaved == 0) {
      this.assessmentService.CollecOptiontData(this.clientIdValue).subscribe(result => {
        this.AllData = result ;
        this.dtTrigger.next();

      });
    }
    else {
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
  }
  isSelected(value: string): boolean {
    return false;
  }
  selectChangeHandler(optionnnnnn, event, id) {
    if (event.target.checked) {
      this.result.push(optionnnnnn.optionText);
    } else {
      this.result.reduceRight(optionnnnnn.optionText);
    }
  }

  onSubmit() {
    alert("Do you want to save");
    this.submit();
  }

  submit() {
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
    this.assessmentService.saveAssessApplication(this.answers).subscribe();
    if (this.myStorage.getCurrentUserObject().isAdmin == 1) {//isAdmin==1 means user
      this.router.navigate(['/user/user-role']);
    }
    else {
      this.router.navigate(['/application']); //admin
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
