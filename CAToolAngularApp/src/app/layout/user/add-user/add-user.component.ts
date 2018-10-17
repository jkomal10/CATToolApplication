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

  constructor(private userService:UsersService,public router: Router) { }

  ngOnInit() {
    this.userService.getIpAddress().subscribe(data => {
      localStorage.setItem('ip',data['ip']);
  });
  }

  addUserComponent(formvalues)
  {
    this.user=formvalues;
    this.user.ipAddress=localStorage.getItem('ip');
    this.userService.addUser(this.user).subscribe();
    this.router.navigate(['/user']);
  }
 
}
