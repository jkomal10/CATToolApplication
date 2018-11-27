import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { LocalStorageService } from '../../utility/service/localStorage.service';
import { Users } from '../../catlogin/Users';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
    userName : string;
    clientName : string;
    user: Users = new Users();

    constructor(public router: Router, private myStorage:LocalStorageService,private translate:TranslateService) {}

    ngOnInit() {
        this.clientName=this.myStorage.getClientName();
        this.user=JSON.parse(localStorage.getItem('user'));   
        this.userName=this.user.userName;
    }
    changeLang(language:string){
        this.translate.use(language);
        localStorage.setItem('language',language);
    }
    onLoggedout()
    {
        this.myStorage.clearCurrentUser();
        this.myStorage.clearLoggedIn();
    }
    
}
