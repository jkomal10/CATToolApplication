import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { UsersService } from './user.service';
import { Subject } from 'rxjs';

// class Person {
//   id: number;
//   first_name: string;
//   last_name: string;
// }

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  // persons: Person[];
  AllData : any = [];
  constructor(private getData : UsersService,
      public router: Router,
    private http: HttpClient) { 

  }
  addUser()
  {
    console.log("This is user component");
    this.router.navigate(['/user/add-user']);
  }

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
  
  }
