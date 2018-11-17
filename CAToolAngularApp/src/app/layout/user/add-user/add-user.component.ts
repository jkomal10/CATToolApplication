import { Component, OnInit } from '@angular/core';
import { AddUserService } from './add-user.service';
import { Users } from '../Users';
import { UsersService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  user: Users;
  AllData : any = [];
 IpAddress : string;
 userName : string;
 status : boolean = true; 
 userTypeValue : number=1;
 userType : string="User";
 clientNameValue : string;

 count:number=0;
 
  constructor(private userService:UsersService,public router: Router) { }

  ngOnInit() {
    this.userService.getIpAddress().subscribe(data => {
      localStorage.setItem('ip',data['ip']);
  });

  this.userService.CollectData().subscribe(result => 
    {
    this.AllData = result ;
    console.log(this.AllData);
    });
  }

  addUserComponent(formvalues)
  {
    this.user=formvalues;
    this.user.isAdmin=this.userTypeValue;
    this.userName=formvalues.userName;
    for (let index = 0; index < this.AllData.length; index++) {
      if(this.userName === this.AllData[index].userName){
        this.status=false;
        console.log(this.status);
        alert("User already exits, please enter a new name");
        this.router.navigate(['/user']);
      }
    }
    if(this.status)
    {
    this.user.ipAddress=localStorage.getItem('ip');
    this.user.clientName=this.clientNameValue;
    this.userService.addUser(this.user).subscribe();
    this.router.navigate(['/user']);
  }

  }

  selectChangeHandler (event: any) {
    if(event.target.value=="User")
    {
      console.log("User is Admin=1");
      this.userTypeValue=1;
      this.user.isAdmin=1;
      this.userType="User";
    }
    else
    {
      console.log("Admin is Admin=0");
      this.userTypeValue=0;
      this.user.isAdmin=0;
      this.userType="Admin";
    }
  }

  selectChangeHandlerForClient(event: any){
    console.log(event.target.value);
    this.clientNameValue=event.target.value;

  }
 
}
