import { Component, OnInit,Input } from '@angular/core';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ViewApplicationService } from './view-application.service';
import { Application } from '../Application';
import { ApplicationService } from '../application.service';
//import { ApplicationComponent } from '../application.component';
//import { ApplicationService } from '../application.service';
//@Input() application: Application;
class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}
@Component({
  selector: 'app-view-application',
  templateUrl: './view-application.component.html',
  styleUrls: ['./view-application.component.scss']
})
export class ViewApplicationComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any = [];
  //Application AllData =new Application();
  //id=11;
  message:String;
  constructor(private router:Router, private http:HttpClient,private getData:ApplicationService) { }
 //constructor(private getData:ApplicationService,private app:ApplicationComponent){}
  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true};
  
       //ViewApplicationById(formvalues){
      // this.getData.CollectSingleApplicationData(this.id).subscribe(result => 
      //   {
      //   this.AllData = result ;
      //   this.dtTrigger.next();
      //   console.log(this.AllData);
      //   });

        this.getData.question.subscribe(data => this.message = data); 
  }
//}

}
