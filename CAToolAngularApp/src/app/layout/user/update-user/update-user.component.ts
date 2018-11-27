import { Component, OnInit } from '@angular/core';
import { UsersService } from '../user.service';
import { Users } from '../Users';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {

  user = new Users();
  userdata : any;
  constructor(private userService : UsersService,public router: Router) { }
  

  ngOnInit() {
    this.userService.users.subscribe(data => {this.userdata= data;}); 
  }

  updateUserComponent(userdata){
    this.user=userdata;
    this.userService.updateUser(userdata).subscribe();
    this.router.navigate(['/user']);
  }

  Cancel()
  {
    this.router.navigate(['/user']);
  }

}
