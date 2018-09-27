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

  //applictaions: Observable<Application[]>;
  AllData : any = [];
  constructor(public router:Router, private applicationService:ApplicationService,private http:HttpClient) { }
  
  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true};

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
  myFunction()
  {
    this.router.navigate(['/application/import-application']);
  }

  updateApplication(){

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
