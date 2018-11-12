import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForCloudableService } from './for-cloudable.service';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { FormsModule }    from '@angular/forms';
import { CloudableRule } from './CloudableRule';

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
  exeorder:any=[];
  constructor(private http:HttpClient,private forCloudableService:ForCloudableService,private router:Router) {
  this.cloudableRules = [];
   }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true,
      rowCallback: (row: Node, data: any[] | Object, index: number) => {
        const self = this;
        // Unbind first in order to avoid any duplicate handler
        // (see https://github.com/l-lin/angular-datatables/issues/87)
        $('td', row).unbind('click');
        $('td', row).bind('click', () => {
          self.someClickHandler(data);
        });
        return row;
    }
  };
  

    this.forCloudableService.CollectData().subscribe(result => {

       this.AllData = result;
       this.dtTrigger.next();
       console.log(this.AllData);
       let abc=result[0];
        //this.op = abc['questionOption'];
       //console.log(this.op[0]['optionText']+"komalll");
      });

   
       this.forCloudableService.collectRule().subscribe(result => {
        this.rules=result;
        
       });
       
      
          // for (let index = 0; index < this.rules.length; index++) {
          //   this.exeorder[index]=this.rules[index].executionOrder;
            
          // }
          // console.log("exeorder***********"+this.exeorder);

       this.forCloudableService.collectQuestion().subscribe(result=>{
         this.questions=result;
         console.log(this.questions);
       });

       this.forCloudableService.collectOptions().subscribe(result =>{
         this.options=result;
         console.log(this.options);
        //  for (let index = 0; index < this.rules.length; index++) {
        //    var qid=this.rules[index].questionId;
        //    for (let index = 0; index < this.options.length; index++) {
        //      if(qid==this.options[index].questionId)
        //      {
        //       var ops= ops+""+this.options[index].optionText;
        //       console.log("&&&&&& **"+ops);
        //      }
        //      this.optionValues[index]=this.ops;
        //     //  console.log("************   "+this.optionValues);
        //    }
           
        //  }
       })


  }
  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  addCloudableRule(){
    for (let index = 0; index < this.rules.length; index++) {
      console.log(this.rules[index].questionId+"*********  qid");
      var cRule : CloudableRule = new CloudableRule();
      cRule.questionId= this.rules[index].questionId;
      console.log(cRule.questionId+"ruleqid");
      cRule.cloudableRule=this.cloudableRulesText[index];
      console.log("rules***"+cRule.cloudableRule);
      cRule.executionOrder=this.executionOrders[index];
      console.log("exeorder****"+ cRule.executionOrder);
      cRule.questionText=this.rules[index].questionText;
      console.log("qtext****"+cRule.questionText);
      cRule.cloudableRuleId=this.rules[index].cloudableRuleId;
      console.log("ruleId***"+cRule.cloudableRuleId);
      this.cloudableRules[index]=cRule;
       this.router.navigate(['/for-cloudable']);
    }
    
    //console.log(cloudableRules+"llllllllllllllllllllllllllllllllll");
    console.log("jjjjjjjjjjjjjjjjjjjj");
    
    console.log(JSON.stringify(this.cloudableRules)+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    this.forCloudableService.addClodableRule(this.cloudableRules).subscribe();
  
  }

  onSubmit(){
   // console.log(formvalues[0]);
    //console.log(JSON.stringify(formvalues[0])+"formmmmmmmmmmmmmmmmmmmmm");
    let cRule=new CloudableRule();
   //console.log(cloudableRule+"6666666666666666")
    //this.option=formvalues;
    //this.cloudableRules.push(cloudableRule);
    
    this.addCloudableRule();
  }
  Cancle(){
    this.router.navigate(['/decision-tree']);
  }
}
