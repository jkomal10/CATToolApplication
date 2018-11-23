import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { UsersService } from '../user/user.service';
import { Router } from '@angular/router';
import { ApplicationService } from '../application/application.service';
import { LocalStorageService } from '../utility/service/localStorage.service';

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
    clientNameValue: string;

    constructor(private userService: UsersService, private applicationService: ApplicationService, public router: Router, private myStorage: LocalStorageService) {
    }

    download() {

    }

    ngOnInit() {
        this.clientNameValue = this.myStorage.getClient();
        this.redirectToDashboard = this.myStorage.getLoggedInTrue();//this.status=localStorage.getItem('isLoggedin');

        if (this.redirectToDashboard == 'true') {

            this.firstName = this.myStorage.getFirstNameOfCurrentUser();
            this.lastName = this.myStorage.getLastNameOfCurrentUser();
            this.userService.CollectData(this.clientNameValue).subscribe(data => { this.users = data });
            this.applicationService.CollectData(this.clientNameValue).subscribe(data => { this.application = data })
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
