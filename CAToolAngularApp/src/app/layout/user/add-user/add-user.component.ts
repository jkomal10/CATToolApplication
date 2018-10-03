import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../user.service';
import { Users } from '../Users';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  user : Users=new Users();
  ipAddress : any;

  constructor(private userservice : UsersService,public router: Router) { }

  ngOnInit() {
    this.userservice.users.subscribe(data => {this.ipAddress= data;}); 
  }

  addUserComponent(formvalues)
  {

    this.user=formvalues;
    console.log("********8888"+formvalues+"******************"+this.user);
    this.userservice.addUser(formvalues)
    .subscribe();
    this.router.navigate(['/user']);

    
  }
}
