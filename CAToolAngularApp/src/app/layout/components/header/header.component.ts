import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { LocalStorageService } from '../../utility/service/localStorage.service';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
    userName : string;
    clientNameValue : String;

    constructor(public router: Router, private myStorage:LocalStorageService) {}

    ngOnInit() {
        this.clientNameValue=this.myStorage.getClient();
        this.userName=this.myStorage.getCurrentUser();      
    }

    onLoggedout()
    {
        this.myStorage.clearCurrentUser();
        this.myStorage.clearLoggedIn();
    }
    
}
