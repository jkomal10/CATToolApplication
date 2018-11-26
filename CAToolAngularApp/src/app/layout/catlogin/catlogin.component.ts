import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { UsersService } from '../user/user.service';
import { Router } from '@angular/router';
import { ApplicationService } from '../application/application.service';
import { Users } from './Users';
import { CatloginService } from './catlogin.service';
import { LocalStorageService } from '../utility/service/localStorage.service';
@Component({
    selector: 'app-catlogin',
    templateUrl: './catlogin.component.html',
    styleUrls: ['./catlogin.component.scss'],
    animations: [routerTransition()]
})
export class CATloginComponent implements OnInit {
    message:String;
    users: Users = new Users();
    userId:string;
    
     constructor(private loginService :CatloginService,public router: Router,private myStorage:LocalStorageService) {}
 
     ngOnInit() {localStorage.setItem('userName',null);
 }
 
     onLoggedin(formValues) { 
          this.loginService.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
          this.users=data;
 
          console.log(this.users + "asdasdasd");
             if( this.users!=null)
             {
                 this.myStorage.setCurrentUserObject(this.users);
                 this.myStorage.setClient(this.users.clientName);
                 this.myStorage.setLoggedInTrue('true'); 
                //  this.myStorage.setUsername(this.users.userName);
                 if(this.users.isAdmin===0)
                 {
                     this.myStorage.setIsUserActive('true');
                     this.message="logged in successfully";
                     this.loginService.sendMsgtoOtherComponent(this.users);
                     this.router.navigate(['/dashboard']);
                 }
                 else if(this.users.isAdmin==1){
                     this.myStorage.setIsUserActive('false');
                     this.loginService.sendMsgtoOtherComponent(this.users.userId);
                     this.loginService.sendMsgtoOtherComponent(this.users);
                     this.router.navigate(['/dashboard']);
                 }
             }
             else
             {
                 alert("Please enter correct username and Password");
             }
             
         }
         
         );
 }
 
 }