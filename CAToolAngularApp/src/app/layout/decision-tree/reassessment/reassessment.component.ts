import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ServiceService } from './reassessment.service';

@Component({
  selector: 'app-reassessment',
  templateUrl: './reassessment.component.html',
  styleUrls: ['./reassessment.component.scss']
})
export class ReassessmentComponent implements OnInit {
  AllData : any = [];

  constructor(public router:Router,private reassessmentService:ServiceService,private http:HttpClient) { }

  ngOnInit() {

    this.reassessmentService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      console.log(this.AllData[2].applicationName+'KKKK(((**************)))JJJJ');
      });

    
  }
}
