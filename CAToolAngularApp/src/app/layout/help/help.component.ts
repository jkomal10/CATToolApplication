import { Component, OnInit } from '@angular/core';
import { HelpService } from './help.service';
import { HttpClient, HttpResponse,HttpHeaders } from '@angular/common/http';
import {ActivatedRoute, Router } from '@angular/router';
import { issue } from './issue';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.scss']
})
export class HelpComponent implements OnInit {

  textfield:string;
  issues:issue=new issue();
  constructor(public helpService:HelpService, public router: Router,
    private http: HttpClient) { }

  ngOnInit() {
   

  }

  submit(){
    // this.textfield=formvalue;
    console.log(this.textfield);
    this.issues.issue=this.textfield;
    this.helpService.saveIssue(this.issues).subscribe();
    this.router.navigate(['/dashboard']);

  }
  
}
