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
    userActive: string;
    userId: number;
    userCheck: boolean;
    isActive: boolean = false;
    public alerts: Array<any> = [];
    public sliders: Array<any> = [];
    firstName: String;
    lastName: String;
    status: string;
    users: any;
    application: any = [];
    clientNameValue: string;

    constructor(private userService: UsersService, private applicationService: ApplicationService, public router: Router) { }

    ngOnInit() {
        this.status='true';
        this.clientNameValue = localStorage.getItem('clientName');
        this.status = localStorage.getItem('isLoggedin');
        if (this.status == 'true') {
            this.firstName = localStorage.getItem('firstName');
            this.lastName = localStorage.getItem('lastName');
            this.userService.CollectData(this.clientNameValue).subscribe(data => { this.users = data });
            this.applicationService.CollectData(this.clientNameValue).subscribe(data => { this.application = data })

            this.userActive = localStorage.getItem('isUserActive');
            if (this.userActive == 'false') {
                this.userCheck = false;
            }
            else {
                this.userCheck = true;
            }
        }
        else {
            this.router.navigate(['/login']);
        }
    }
}
