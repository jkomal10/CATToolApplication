import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';

import{LoginService} from './login.service';
import { Users } from './Users';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    message:String;
   users: Users = new Users();
   userId:string;
   
    constructor(private loginService :LoginService,public router: Router,private loginservice : LoginService) {}

    ngOnInit() {localStorage.setItem('userName',null);
}

    onLoggedin(formValues) {
        //  localStorage.setItem('isLoggedin', 'true');   
         this.loginservice.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
         this.users=data;
        //  console.log('****************************************'+this.users.password);

         console.log(this.users + "asdasdasd");
            if( this.users!=null)
            {
                localStorage.setItem('isLoggedin', 'true');   
                if(this.users.isAdmin===0)
                {
                    localStorage.setItem('isUserActive','true');
                    console.log("is adminnnnnnnnnnn"+this.users.isAdmin)
                    localStorage.setItem('firstName',this.users.firstName);
                    localStorage.setItem('lastName',this.users.lastName);
                    this.message="uuuu";
                    localStorage.setItem('userName',formValues.userName);
                    this.loginService.sendMsgtoOtherComponent(this.users);
                    this.router.navigate(['/dashboard']);
                }
                else if(this.users.isAdmin==1){
                    localStorage.setItem('isUserActive','false');
                    console.log(JSON.stringify(this.users));
                    this.loginService.sendMsgtoOtherComponent(this.users.userId);
                    localStorage.setItem('firstName',this.users.firstName);
                    localStorage.setItem('lastName',this.users.lastName);
                    localStorage.setItem('userName',formValues.userName);
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