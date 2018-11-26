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
    clientNameValue : String;
    user: Users = new Users();

    constructor(public router: Router, private myStorage:LocalStorageService,private translate:TranslateService) {}

    ngOnInit() {
        this.clientNameValue=this.myStorage.getClient();
        this.user=JSON.parse(localStorage.getItem('user'));   
        this.userName=this.user.userName;
    }
    changeLang(language:string){
        this.translate.use(language);
        //return language;
        localStorage.setItem('language',language);
    }
    onLoggedout()
    {
        this.myStorage.clearCurrentUser();
        this.myStorage.clearLoggedIn();
    }
    
}
