import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ForCloudableService } from './for-cloudable.service';
import { Subject } from 'rxjs';
import { Option } from '../../assessment-questions/Option';
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
  //option: Option=new Option();
  option:any;
  assessmentQuestions : object [];
  message = '';
  user_data: any;
  constructor(private http:HttpClient,private forCloudableService:ForCloudableService) { }

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

      // let user = result [0]["assessmentQuestions"];
      //           let user_data = user["data"];
      //           console.log(user_data["name"]);
      //           this.user_data = user_data; // here
      //           console.log();
      // {this.AllData=result as Object[];
      //    // FILL THE ARRAY WITH DATA.
      //   console.log(this.AllData)
      //  let res=result[4];
      //    this.assessmentQuestions = res ['assessmentQuestions'] ;
      //   console.log(this.assessmentQuestions[0]['questionType']+"******************")

        // let assessmentQuestions=result["assessmentQuestions"];
        // let AllData=assessmentQuestions[0];
        // console.log(AllData["questionType"])

        //previous
       this.AllData = result;
       //this.option=this.AllData.assessmentQuestions;
       this.dtTrigger.next();
       console.log(this.AllData);

       console.log(this.AllData[28].questionType);
       console.log(this.AllData[28].assessmentQuestions);
       console.log(this.AllData[28].assessmentQuestions.questionType);
      console.log(this.option+"***********************");
      
      });

  }
  //   getGFValues(ob): any[] {
  //     return Object.values(ob);
  //     }
  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

}
