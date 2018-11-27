import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForCloudableService } from './for-cloudable.service';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { FormsModule }    from '@angular/forms';
import { CloudableRule } from './CloudableRule';
import { LocalStorageService } from '../../utility/service/localStorage.service';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-for-cloudable',
  templateUrl: './for-cloudable.component.html',
  styleUrls: ['./for-cloudable.component.scss']
})
export class ForCloudableComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any;
  rules : any = [];
  options : any =[];
  optionValues : any = [];
  questions:any=[];
  ops:string;
  //option: QuestionOption=new QuestionOption();
  //op :object [];
  //assessmentQuestions : object [];
  message = '';
  user_data: any;

  //length = this.AllData.length;
  executionOrders : Array<number> = [];
  cloudableRulesText : Array<String> = [];
  cloudableRules : Array<CloudableRule> = [];
  orderByQuestionDisplayOrder : any = [];
  cloudableQuestions : any = [];
  exeorder:any=[];
  constructor(private http:HttpClient,private forCloudableService:ForCloudableService,private router:Router,private myStorage:LocalStorageService) {
  this.cloudableRules = [];
   }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true,
      rowCallback: (row: Node, data: any[] | Object, index: number) => {
        const self = this;
        $('td', row).unbind('click');
        $('td', row).bind('click', () => {
          self.someClickHandler(data);
        });
        return row;
    }
  };


  
  

    this.forCloudableService.getCloudableQuestions().subscribe(result => {
        this.AllData = result;
        this.dtTrigger.next();
      });

   
       this.forCloudableService.collectRule().subscribe(result => {
        this.rules=result;
        
       });

       this.forCloudableService.collectQuestion(this.myStorage.getCurrentUserObject().clientId).subscribe(result=>{
         this.questions=result;
       });

       this.forCloudableService.collectOptions().subscribe(result =>{
         this.options=result;
       })


  }
  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  addCloudableRule(){
    for (let index = 0; index < this.rules.length; index++) {
      var cRule : CloudableRule = new CloudableRule();
      cRule.questionId= this.rules[index].questionId;
      cRule.cloudableRule=this.cloudableRulesText[index];
      cRule.executionOrder=this.executionOrders[index];
      cRule.questionText=this.rules[index].questionText;
      cRule.cloudableRuleId=this.rules[index].cloudableRuleId;
      this.cloudableRules[index]=cRule;
      this.router.navigate(['/for-cloudable']);
    }
    this.forCloudableService.addClodableRule(this.cloudableRules).subscribe();
  }

  onSubmit(){
    let cRule=new CloudableRule();
    this.addCloudableRule();
  }
  Cancle(){
    this.router.navigate(['/decision-tree']);
  }

  selectChangeHandler(event:any)
  {
    if(event.target.value=="QuestionDisplayOrder")
    {
      let small : number = 0;
      this.cloudableQuestions.sort(function(question1,question2){
        if(question1.questionDisplayOrder>question2.questionDisplayOrder) return -1;
        if(question1.questionDisplayOrder<question2.questionDisplayOrder) return 1;
      })

        for (let index = 0; index < this.rules.length; index++) {
          console.log("*********"+this.rules[index].questionDisplayOrder);
        }
    }
    else
    {

    }
  }

}
