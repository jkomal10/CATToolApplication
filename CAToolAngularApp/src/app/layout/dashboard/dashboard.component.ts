import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { UsersService } from '../user/user.service';
import { Router } from '@angular/router';
import { ApplicationService } from '../application/application.service';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {
    userActive : string;
    userId : number;
    userCheck : boolean;
    isActive: boolean = false;
    public alerts: Array<any> = [];
    public sliders: Array<any> = [];
    firstName: String;
    lastName : String;
    status:string;
    users : any;
    application : any = [];
    clientNameValue : string;
    //applicationCount: number;
    

    constructor(private userService:UsersService,private applicationService:ApplicationService,public router: Router) {
        this.sliders.push(
            {
                imagePath: 'assets/images/slider1.jpg',
                label: 'First slide label',
                text:
                    'Nulla vitae elit libero, a pharetra augue mollis interdum.'
            },
            {
                imagePath: 'assets/images/slider2.jpg',
                label: 'Second slide label',
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
            },
            {
                imagePath: 'assets/images/slider3.jpg',
                label: 'Third slide label',
                text:
                    'Praesent commodo cursus magna, vel scelerisque nisl consectetur.'
            }
        );

        this.alerts.push(
            {
                id: 1,
                type: 'success',
                message: `Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Voluptates est animi quibusdam praesentium quam, et perspiciatis,
                consectetur velit culpa molestias dignissimos
                voluptatum veritatis quod aliquam! Rerum placeat necessitatibus, vitae dolorum`
            },
            {
                id: 2,
                type: 'warning',
                message: `Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Voluptates est animi quibusdam praesentium quam, et perspiciatis,
                consectetur velit culpa molestias dignissimos
                voluptatum veritatis quod aliquam! Rerum placeat necessitatibus, vitae dolorum`
            }
        );
    }

    ngOnInit() {
        this.clientNameValue=localStorage.getItem('clientName');
          this.status=localStorage.getItem('isLoggedin');
          console.log(this.status);

        if(this.status=='true')
        {
        this.firstName=localStorage.getItem('firstName');
        this.lastName=localStorage.getItem('lastName');
        this.userService.CollectData(this.clientNameValue).subscribe(data=>{this.users=data});
        this.applicationService.CollectData(this.clientNameValue).subscribe(data=>{this.application=data})
        // this.users=10;
        // this.applicationCount=this.application.length();
         //console.log(this.applicationCount+"kkkkkkkkkkkkkk");
            this.userActive=localStorage.getItem('isUserActive');
            if(this.userActive=='false')
            {
                this.userCheck=false;
                console.log(this.userCheck+"*****this.userCheck*******false***********************");
            }
            else{
                this.userCheck=true;
                console.log(this.userCheck+"*****this.userCheck*******true***********************");
            }
            console.log(this.userActive+"****this.userActive*******************************");
        }
        else{
            this.router.navigate(['/login']);
        }
    }

    public closeAlert(alert: any) {
        const index: number = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    }
}
