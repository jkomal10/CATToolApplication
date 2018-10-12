import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForCloudableService } from './for-cloudable.service';
import { Subject } from 'rxjs';
import { Option } from '../../assessment-questions/Option';
import { Router } from '@angular/router';
import { CloudableRule } from './cloudable';
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
  option: Option=new Option();
 // option:any;
  assessmentQuestions : object [];
  message = '';
  user_data: any;
  constructor(private http:HttpClient,private forCloudableService:ForCloudableService,private router:Router) { }

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

  addCloudableRule(option){
    console.log(option+"llllllllllllllllllllllllllllllllll");
    console.log("jjjjjjjjjjjjjjjjjjjj");
    
    console.log(this.option+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    this.forCloudableService.addClodableRule(this.option).subscribe();
  
  }

  onSubmit(executionOrder){
   // let cloudableRule=new CloudableRule(executionOrder);
    //this.option=formvalues;
    console.log(this.option+"ooooooooooooooooooooo");
    this.addCloudableRule(this.option);
  }
}
