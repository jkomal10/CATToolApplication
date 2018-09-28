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
    users= new Users();
    // password : string = "pass";
    // username : string = "user";
    constructor(public router: Router,private loginservice : LoginService) {}

    ngOnInit() {}

    onLoggedin(formValues) {
         localStorage.setItem('isLoggedin', 'true');   
         this.loginservice.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
         this.users=data;
         console.log(this.users);
            if( this.users!=null)
            {
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