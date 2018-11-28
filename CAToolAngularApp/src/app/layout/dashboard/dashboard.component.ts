import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { UsersService } from '../user/user.service';
import { Router } from '@angular/router';
import { ApplicationService } from '../application/application.service';
import { LocalStorageService } from '../utility/service/localStorage.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {
    isUser: string;
    userId: number;
    isAdmin: boolean;
    isActive: boolean = false;
    public alerts: Array<any> = [];
    public sliders: Array<any> = [];
    firstName: String;
    lastName: String;
    redirectToDashboard: string;
    users: any;
    application: any = [];
    appCount : any = [];

    userCount: any=[];
 

    clientIdValue: number;


    constructor(private translate: TranslateService,private userService: UsersService, private applicationService: ApplicationService, public router: Router, private myStorage: LocalStorageService) {
    }

    download() {

    }

    ngOnInit() {
        this.clientIdValue = this.myStorage.getCurrentUserObject().clientId;
        this.redirectToDashboard = this.myStorage.getLoggedInTrue();
        if (this.redirectToDashboard == 'true') {
            this.firstName = this.myStorage.getCurrentUserObject().firstName;
            this.lastName = this.myStorage.getCurrentUserObject().lastName;
            this.userService.getUsersCount(this.clientIdValue).subscribe(data=>{this.userCount=data,console.log(this.userCount)});
            this.userService.getAllUsers(this.clientIdValue).subscribe(data => { this.users = data });
            this.applicationService.getAllAplication(this.clientIdValue).subscribe(data => { this.application = data });
            this.applicationService.getApplicationCount(this.clientIdValue).subscribe(data=>{this.appCount=data,console.log(this.appCount)});
            if (this.myStorage.getCurrentUserObject().isAdmin==1) {
                this.isAdmin = false;
            }
            else {
                this.isAdmin = true;
            }
        }
        else {
            this.router.navigate(['/login']);
        }
    }

    public closeAlert(alert: any) {
        const index: number = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    }
}
