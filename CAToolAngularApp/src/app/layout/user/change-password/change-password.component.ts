import { Component, OnInit } from '@angular/core';
import { UsersService } from '../user.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  previousPassword: String;

  constructor(private userService:UsersService, private myStorage:LocalStorageService) { }

  ngOnInit() {
  }

  onLoggedin(formvalues){
    this.userService.changePassword(this.myStorage.getCurrentUserObject().userName,formvalues.previousPassword,formvalues.password).subscribe();
  }

}
