import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
    userName : string;
    clientNameValue : String;

    constructor(public router: Router) {}

    ngOnInit() {
        this.clientNameValue=localStorage.getItem('clientName');
        console.log(this.clientNameValue);
       this.userName=localStorage.getItem('userName');
        console.log(this.userName);
        
    }

    onLoggedout()
    {
        localStorage.removeItem('userName');
        localStorage.removeItem('isLoggedin');
        localStorage.clear();
    }
    
}
