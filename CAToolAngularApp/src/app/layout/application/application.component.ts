import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject, Observable } from '../../../../node_modules/rxjs';
import { ApplicationService } from './application.service';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  message = '';
  //applictaions: Observable<Application[]>;
  AllData : any = [];
  constructor(public router:Router, private applicationService:ApplicationService,private http:HttpClient) { }
  
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

    this.applicationService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      });


  }
  form(){
    this.router.navigate(['/application/add-application']);
  }

  someClickHandler(info: any): void {
    this.message = info.id + ' - ' + info.firstName;
  }

  myFunction()
  {
    this.router.navigate(['/application/import-application']);
  }
  editApplication(application: Application): void {
    console.log(JSON.stringify(application));
    this.applicationService.sendMsgtoOtherComponent(application);
    this.router.navigate(['/application/update-application']);
  }
  

  
  deleteApplication(formvalues) {
    this.applicationService.deleteApplications(formvalues)
    .subscribe(
      data => {
        console.log(data);
        //this.reloadData();
        //this.router.navigate(['/applictaion']);
        this.reloadData();
        //this.getData.CollectData();
      },
      error => console.log('ERROR: ' + error));
      // this.router.navigate(['/applictaion']);
  }

  resetApplication(formvalues){
    this.applicationService.resetApplication(formvalues)
    .subscribe();
  }

   reloadData() {
     this.applicationService.CollectData();
   }
   
   ViewApplication(formvalues){
     this.applicationService.sendMsgtoOtherComponent(formvalues);
     console.log(formvalues);
    this.router.navigate(['/application/view-application']);
   }
   assessApplication(){
     this.router.navigate(['/application/assesst-application']);
   }

}
