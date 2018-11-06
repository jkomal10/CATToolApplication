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
  //option: QuestionOption=new QuestionOption();
  //op :object [];
  //assessmentQuestions : object [];
  message = '';
  user_data: any;

  //length = this.AllData.length;
  executionOrders : Array<number> = [];
  cloudableRulesText : Array<String> = [];
  cloudableRules : Array<CloudableRule> = [];
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

  }
  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  addCloudableRule(){
    for (let index = 0; index < this.AllData.length; index++) {
      console.log(this.AllData[index].questionId+"Alldata");
      var cRule : CloudableRule = new CloudableRule();
      cRule.questionId= this.AllData[index].questionId;
      console.log(cRule.questionId+"rule");
      cRule.cloudableRule=this.cloudableRulesText[index];
      cRule.executionOrder=this.executionOrders[index];
      cRule.questionText=this.AllData[index].questionText
      this.cloudableRules[index]=cRule;
       this.router.navigate(['/for-cloudable']);
    }
    
    //console.log(cloudableRules+"llllllllllllllllllllllllllllllllll");
    console.log("jjjjjjjjjjjjjjjjjjjj");
    
    console.log(JSON.stringify(this.cloudableRules[0])+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
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
    this.router.navigate(['/for-cloudable']);
  }
}
