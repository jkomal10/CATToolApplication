import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { CatloginService } from './catlogin.service';
import { Users } from './Users';

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
  
   constructor(private loginService :CatloginService,public router: Router) {}

   ngOnInit() {localStorage.setItem('userName',null);
}

onLoggedin(formValues) {
    //  localStorage.setItem('isLoggedin', 'true');   
     this.loginService.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
     this.users=data;
    //  console.log('****************************************'+this.users.password);

     console.log(this.users + "asdasdasd");
        if( this.users!=null)
        {
            localStorage.setItem('isLoggedin', 'true');   
            if(this.users.isAdmin===0)
            {
                localStorage.setItem('isUserActive','true');
                localStorage.setItem('clientName',this.users.clientName);
                console.log("client name=="+this.users.clientName);
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
                localStorage.setItem('clientName',this.users.clientName);
                console.log("client name=="+this.users.clientName);
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