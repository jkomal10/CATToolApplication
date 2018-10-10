import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { UsersService } from './user.service';
import { Subject } from 'rxjs';
import { Users } from './Users';

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

  user: Users;
  public IpAddress;
 
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  // persons: Person[];
  AllData : any = [];
  constructor(private userService : UsersService,
      public router: Router,
    private http: HttpClient) { 

  }
  addUser()
  {
    console.log("This is user component");
    console.log(this.IpAddress);
    this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
    this.router.navigate(['/user/add-user']);
  }

  updateUser(user:Users){
    console.log(user);
     this.userService.sendMsgtoOtherComponent(user);
     this.router.navigate(['/user/update-user']);
  }

  deleteUser(formvalues){
    console.log(formvalues);
    this.userService.deleteUser(formvalues).subscribe(data => {
      console.log(data);
    },
    error => console.log('ERROR: ' + error));
    this.router.navigate(['/user']);
    

  }
  uploadUserInfo()
  {
    console.log(this.IpAddress);
    this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
    this.router.navigate(['/user/upload-user']);
  }
  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};

    this.userService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      //console.log(this.AllData);
      }); 
      
      console.log("ip");
      this.userService.getIpAddress().subscribe(data => {
      this.IpAddress=data['ip'];
      console.log(data['ip']);
      console.log(this.IpAddress);
      console.log(data);
    });

  //   this.http.get('https://api.ipify.org?format=json').subscribe(data => {
  //     this.publicIP=data['ip'];
  //    // console.log(this.publicIP);
  //   });
  //  // console.log(this.publicIP);
     

  }
  
  }
