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
 count:number=0;

  constructor(private userService:UsersService,public router: Router) { }

  ngOnInit() {
    this.userService.getIpAddress().subscribe(data => {
      localStorage.setItem('ip',data['ip']);
  });

  this.userService.CollectData().subscribe(result => 
    {
    this.AllData = result ;
    });
  }

  addUserComponent(formvalues)
  {
    this.user=formvalues;
    this.user.ipAddress=localStorage.getItem('ip');
    //console.log("All user data ++++"+JSON.stringify(this.AllData));
    console.log("oooooooooooooooooooooooooooooooooooo");
    for(let index = 0; index < this.AllData.length; index++)
    {
        console.log("oooooooooooooooooooooooooooooooooooocount000"+this.count);
        if(this.AllData[index].userName==formvalues.userName)
        {
          console.log(this.AllData[index].userName+"==user=="+formvalues.userName);
          console.log("count value =="+this.count);
          this.count++;
          console.log("==count value =="+this.count);
          this.router.navigate(['/user/add-user']);
          break;
        }
    }
    if(this.count==0){
    this.userService.addUser(this.user).subscribe();
    this.router.navigate(['/user']);
    this.count=0;
  }
  else
  {
    this.count=0;
    this.router.navigate(['/user/add-user']); 
  }
    
  }
 
}
