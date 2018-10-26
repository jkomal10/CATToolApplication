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
   users: Users = new Users();
    // password : string = "pass";
    // username : string = "user";
    constructor(private loginService :LoginService,public router: Router,private loginservice : LoginService) {}

    ngOnInit() {localStorage.setItem('userName',null);}

    onLoggedin(formValues) {
         localStorage.setItem('isLoggedin', 'true');   
         this.loginservice.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
         this.users=data;
         console.log(this.users);
            if( this.users!=null)
            {
                localStorage.setItem('userName',formValues.userName);
                this.loginService.sendMsgtoOtherComponent(this.users);
                this.router.navigate(['/dashboard']);
            }
            else
            {
                this.router.navigate(['/login']);
            }
            
        }
        
        );
}
}