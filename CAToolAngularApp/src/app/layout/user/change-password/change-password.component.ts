import { Component, OnInit } from '@angular/core';
import { UsersService } from '../user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  previousPassword: String;
  userName: String;

  constructor(private userService:UsersService) { }

  ngOnInit() {
    this.userName=localStorage.getItem('userName');
  }

  onLoggedin(formvalues){
    console.log("Change password works!!!!"+formvalues.previousPassword+formvalues.password);
    this.userService.changePassword(this.userName,formvalues.previousPassword,formvalues.password).subscribe();
  }

}
