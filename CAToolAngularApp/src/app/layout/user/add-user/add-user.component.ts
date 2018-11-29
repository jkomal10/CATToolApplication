import { Component, OnInit } from '@angular/core';
import { AddUserService } from './add-user.service';
import { Users } from '../Users';
import { UsersService } from '../user.service';
import { Router } from '@angular/router';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  user: Users;
  AllData :  any  =  [];
  IpAddress: string;
  userName: string;
  status: boolean = true;
  userTypeValue: number = 1;
  userType: string = "User";
  clientIdValue: number;

  count: number = 0;

  constructor(private userService: UsersService, public router: Router, private myStorage: LocalStorageService) {
  }

  ngOnInit() {
    this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
    this.userService.getIpAddress().subscribe(data => {
      this.myStorage.setIpAddress(data['ip']);
    });

    this.userService.getAllUsers(this.clientIdValue).subscribe(result  => {
      this.AllData  =  result ;
    });
  }

  addUserComponent(formvalues) {
    this.user = formvalues;
    this.user.isAdmin = this.userTypeValue;
    this.userName = formvalues.userName;
    for (let index = 0; index < this.AllData.length; index++) {
      if (this.userName === this.AllData[index].userName) {
        this.status = false;
        alert("User already exits, please enter a new name");
        location.reload();
        this.router.navigate(['/user']);
      }
    }
    if (this.status) {
      this.user.ipAddress = this.myStorage.getIpAddress();
      this.user.createdBy = this.myStorage.getCurrentUserObject().userName;
      this.user.clientId = this.clientIdValue;
      this.userService.addUser(this.user).subscribe();
      location.reload();
      this.router.navigate(['/user']);
    }
  }

  selectChangeHandler(event: any) {
    if (event.target.value == "User") {
      this.userTypeValue = 1;
      this.user.isAdmin = 1;
      this.userType = "User";
    }
    else {
      this.userTypeValue = 0;
      this.user.isAdmin = 0;
      this.userType = "Admin";
    }
  }

}
