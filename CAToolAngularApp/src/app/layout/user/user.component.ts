import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import { UsersService } from './user.service';
import { Subject } from 'rxjs';
import { Users } from './Users';
import { Angular5Csv } from 'angular5-csv/Angular5-csv';

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

  player: YT.Player;
  private id: string = '0eWrpsCLMJQ';

  savePlayer(player) {
    this.player = player;
    console.log('Video Url', player.getVideoUrl());
  }
  onStateChange(event) {
    console.log('player state', event.data);
  }

  user: Users;
  IpAddress : string;
 
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  // persons: Person[];
  users:Array<Users>=[];
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

  deactivate(formvalues)
  {
   this.userService.deactivate(formvalues).subscribe();
  }

  uploadUserInfo()
  {
    console.log(this.IpAddress);
    this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
    this.router.navigate(['/user/upload-user']);
  }

  exportCsv(){
    var filename = "UserDetails";
   for (let index = 0; index < this.AllData.length; index++) {
     this.users[index]=this.AllData[index];
     
   }
   var options={
     headers:["userId","userName","firstName","lastName","password","ipAddress","lastLogin","company","isDeleted",
              "isDeactivate","createdDateTime","createdBy","modifiedDateTime","modifiedBy","isAdmin"]
   };
   new Angular5Csv(this.users, filename, options);
  }

  help()
  {
    // this.userService.sendUsertoOtherComponent("user");
    localStorage.setItem('component', 'user');   
    this.router.navigate(['/help']);
  }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};
      this.userService.getIpAddress().subscribe(data => {
        this.IpAddress=data['ip'];

    this.userService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      });
 
    });
     
    
  }
  
  }
