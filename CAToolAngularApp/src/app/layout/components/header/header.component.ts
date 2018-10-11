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

    constructor(public router: Router) {}

    ngOnInit() {
       this.userName=localStorage.getItem('userName');
        console.log(this.userName);
        
    }
    
}
