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
 IpAddress : string;
 AllData : any = [];
 userName : string;
 status : boolean = true; 

  constructor(private userService:UsersService,public router: Router) { }

  ngOnInit() {
    this.userService.getIpAddress().subscribe(data => {
      localStorage.setItem('ip',data['ip']);
  });

  this.userService.CollectData().subscribe(result => 
    {
    this.AllData = result ;
    // this.dtTrigger.next();
    console.log(this.AllData);
    });

    // console.log(this.AllData);
  }

  addUserComponent(formvalues)
  {
    this.user=formvalues;
    this.userName=formvalues.userName;
    console.log(this.userName);
    console.log(this.AllData.length);
    for (let index = 0; index < this.AllData.length; index++) {
      // const element = array[index];

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
    console.log("******+++++*");
     this.userService.addUser(this.user).subscribe();
     this.router.navigate(['/user']);
  }
    // this.userService.addUser(this.user).subscribe();
    // this.router.navigate(['/user']);
  }
 
}
