import { Component, OnInit } from '@angular/core';
import { UsersService } from '../user.service';
import {ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { Subject } from 'rxjs';
import { UserRoleService } from './user-role.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  selector: 'app-user-role',
  templateUrl: './user-role.component.html',
  styleUrls: ['./user-role.component.scss']
})
export class UserRoleComponent implements OnInit {
  userName:string;
  userRoleData : any = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  constructor(private userRoleService :UserRoleService, public router: Router, private http: HttpClient,private myStorage:LocalStorageService) { 
}

  ngOnInit() {
    this.userName=this.myStorage.getCurrentUserObject().userName;
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};

  this.userRoleService.getApplicationByUserName(this.userName).subscribe(result => 
    {
      this.userRoleData= result ;
      this.dtTrigger.next();
    });
  }

  assessApplication(formvalues){
      this.userRoleService.sendMsgtoOtherComponent(formvalues);
      this.router.navigate(['/application/assesst-application']);
  }

  ViewApplication(formvalues){
      this.userRoleService.sendMsgtoOtherComponent(formvalues);
      this.router.navigate(['/application/view-application']);
  }  

}
