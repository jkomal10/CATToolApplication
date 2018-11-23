import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { CatloginService } from './catlogin.service';
import { Users } from './Users';
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
    
    constructor(private loginService :CatloginService,public router: Router,private myStorage : LocalStorageService) {}

    ngOnInit() {}

    onLoggedin(formValues) { 
        this.loginService.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
        this.users=data; 
        if( this.users!=null)
        {
            this.myStorage.setLoggedInTrue('true'); //set is logged in true in session
            this.myStorage.setCurrentUserObject(this.users); //set current user object in session

            if(this.users.isAdmin===0)
            {
                this.myStorage.setIsUserActive('true');
                this.message="admin";
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