import { Component, OnInit } from '@angular/core';
import { AddUserService } from './add-user.service';
import { Users } from '../../../login/Users';
import { UsersService } from '../user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
 user =new Users();
  constructor(private userService:UsersService) { }

  ngOnInit() {
  }

  addUserComponent(formvalues)
  {
    this.user=formvalues;
    console.log(formvalues);
  this.userService.addUser(this.user).subscribe();
    //console.log("********8888"+formvalues);
    
  }

  // save() {
  //   this.addapplicationService.createApplication(this.application)
  //     .subscribe(data => console.log(data), error => console.log(error));
  //   this.application = new Application();
  // }
 
}
