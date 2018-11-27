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
    clientNameValue: string;

    constructor(private translate: TranslateService,private userService: UsersService, private applicationService: ApplicationService, public router: Router, private myStorage: LocalStorageService) {
    }

    download() {

    }

    ngOnInit() {
        this.clientNameValue = this.myStorage.getCurrentUserObject().clientName;
        this.redirectToDashboard = this.myStorage.getLoggedInTrue();//this.status=localStorage.getItem('isLoggedin');

        if (this.redirectToDashboard == 'true') {

            this.firstName = this.myStorage.getCurrentUserObject().firstName;
            this.lastName = this.myStorage.getCurrentUserObject().lastName;
            this.userService.getAllUsers(this.clientNameValue).subscribe(data => { this.users = data });
            this.applicationService.CollectData(this.clientNameValue).subscribe(data => { this.application = data });
            this.applicationService.getApplicationCount(this.clientNameValue).subscribe(data=>{this.appCount=data,console.log(this.appCount)});
            this.userService.getUsersCount(this.clientNameValue).subscribe(data=>{this.userCount=data,console.log(this.userCount)});
            this.isUser = this.myStorage.getIsUserActive();
            if (this.isUser == 'false') {
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
