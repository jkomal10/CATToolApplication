import { Component, OnInit } from '@angular/core';
import { HelpService } from './help.service';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import {ActivatedRoute, Router } from '@angular/router';
import { issue } from './issue';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.scss']
})
export class HelpComponent implements OnInit {

  textfield:string;
  issues:issue=new issue();
  constructor(public helpService:HelpService, public router: Router,private http: HttpClient, private myStorage:LocalStorageService) { }

  ngOnInit() {
   

  }

  submit(){
    this.issues.issue=this.textfield;
    this.issues.userName=this.myStorage.getCurrentUserObject().userName;
    this.issues.clientId=this.myStorage.getCurrentUserObject().clientId;
    this.helpService.saveIssue(this.issues).subscribe();
    this.router.navigate(['/dashboard']);

  }
  
}
