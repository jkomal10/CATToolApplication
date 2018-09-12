import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';

import{LoginService} from './login.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    public user;
    password : string = "pass";
    username : string = "user";
    constructor(public router: Router,private loginservice : LoginService) {}

    ngOnInit() {}

    onLoggedin(formValues) {
         console.log(formValues.username+" && "+formValues.password);
         localStorage.setItem('isLoggedin', 'true');   
         if(formValues.password==this.password)
         {
            this.router.navigate(['/dashboard']);
            console.log(this.username);
         }    
        //  this.loginservice.getUserByID(formValues.username).subscribe((data) => {
        //     this.user = data;
        //     if(this.user.password != null){
        //         if(formValues.password == this.user.password){
        //             console.log(this.user.password);
        //             this.router.navigate(['/dashboard']);
        //         }
                else{
                     alert("invalid Password");
                }
            }
            // else{
            //     alert("invalid UserName");
            // }});
    
        //this.router.navigate(['/dashboard']);
    //}
}
