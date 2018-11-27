import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { UsersService } from './user.service';
import { Subject } from 'rxjs';
import { Users } from './Users';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';
import { LocalStorageService } from '../utility/service/localStorage.service';

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

  clientValue : string;
  user: Users;
  IpAddress : string;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  users:Array<Users>=[];
  userData: any = [];

  constructor(private userService : UsersService,public router: Router,private http: HttpClient,private myStorage:LocalStorageService) { 
  }
  
  addUser()
  {
    this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
    this.router.navigate(['/user/add-user']);
  }

  updateUser(user:Users){
     this.userService.sendMsgtoOtherComponent(user);
     this.router.navigate(['/user/update-user']);
  }

  deleteUser(formvalues){
    this.userService.deleteUser(formvalues).subscribe(data => {},
    error => console.log('ERROR: ' + error));
    this.router.navigate(['/user']);
  }

  deactivate(formvalues)
  {
   this.userService.deactivate(formvalues).subscribe();
  }

  uploadUserInfo()
  {
    this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
    this.router.navigate(['/user/upload-user']);
  }

  exportCsvTemplate()
  {
    var filename = "Users";
    var options={
      headers:[ "User Name","First Name","Last Name","Company","UserType"]
    };
    new Angular5Csv(this.users, filename, options);
  }


  exportCsv(){
    var filename = "UserDetails";
   for (let index = 0; index < this.userData.length; index++) {
     this.users[index]=this.userData[index];
     
   }
   var options={
     headers:["userId","userName","firstName","lastName","password","ipAddress","lastLogin","company","isDeleted",
              "isDeactivate","createdDateTime","createdBy","modifiedDateTime","modifiedBy","isAdmin"]
   };
   new Angular5Csv(this.users, filename, options);
  }

  help()
  {
    this.myStorage.setComponent('user');  
    this.router.navigate(['/help']);
  }

  ngOnInit() {

    this.clientValue=this.myStorage.getCurrentUserObject().clientName;

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};
      this.userService.getIpAddress().subscribe(data => {
        this.IpAddress=data['ip'];

    this.userService.getAllUsers(this.clientValue).subscribe(result => 
      {
      this.userData= result ;
      this.dtTrigger.next();
      });
 
    });
     
    
  }
  
  }
