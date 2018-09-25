import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from '../../../../node_modules/rxjs';
import { ApplicationService } from './application.service';
import { HttpClient } from '@angular/common/http';

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

  
  AllData : any = [];
  constructor(public router:Router, private getData:ApplicationService,private http:HttpClient) { }
  
  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true};

    this.getData.CollectData().subscribe(result => 
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

}
