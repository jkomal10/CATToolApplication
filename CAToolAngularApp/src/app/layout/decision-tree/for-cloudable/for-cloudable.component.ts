import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForCloudableService } from './for-cloudable.service';
import { Subject } from 'rxjs';

import { Router } from '@angular/router';
import { CloudableRule } from './cloudable';
import { QuestionOption } from '../../assessment-questions/Option';
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
  option: QuestionOption=new QuestionOption();
 // option:any;
  assessmentQuestions : object [];
  message = '';
  user_data: any;
  cloudableRules:Array<CloudableRule>;
  constructor(private http:HttpClient,private forCloudableService:ForCloudableService,private router:Router) {
    this.cloudableRules=[];
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
       //this.option=this.AllData.assessmentQuestions;
       this.dtTrigger.next();
       console.log(this.AllData);
     console.log(this.AllData[0].assessmentQuestions);
     console.log(this.AllData[2].assessmentQuestions.questionType);

        // this.option=this.AllData.optionId;
        // this.option=this.AllData.optionText;
        // this.option=this.AllData.assessmentQuestions;
     // console.log(this.option+"*************"+this.AllData+"**********");
      
      });

  }
  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  addCloudableRule(cloudableRules){
    console.log(cloudableRules+"llllllllllllllllllllllllllllllllll");
    console.log("jjjjjjjjjjjjjjjjjjjj");
    
    //console.log(this.option+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    this.forCloudableService.addClodableRule(this.cloudableRules).subscribe();
  
  }

  onSubmit(questionText,executionOrder,questionType,optionText){
    let cloudableRule=new CloudableRule(questionText,executionOrder,questionType,optionText);
   console.log(cloudableRule+"6666666666666666")
    //this.option=formvalues;
    this.cloudableRules.push(cloudableRule);
    console.log(this.option+"ooooooooooooooooooooo");
    this.addCloudableRule(this.cloudableRules);
  }
}
