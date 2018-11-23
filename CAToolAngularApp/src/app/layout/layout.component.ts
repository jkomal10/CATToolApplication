import { Component, OnInit } from '@angular/core';
import { Users } from './user/Users';

@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
    // users: Users = new Users();
    // usersdata : any;
    collapedSideBar: boolean;

    constructor() {}
    //private loginService :LoginService

    ngOnInit() {
        // this.loginService.question.subscribe(data => {this.usersdata= data;});
        // console.log(this.usersdata+'+++++++++++++++++++++++++++++++++++++++????????????????????++++++++++++++++++++++++');
    }

    receiveCollapsed($event) {
        this.collapedSideBar = $event;
    }
}
