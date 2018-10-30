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
  countApplicationId : number[];

  constructor(public router:Router,private reassessmentService:ServiceService,private http:HttpClient) { }

  ngOnInit() {

    this.reassessmentService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      });

    
  }

  runRule(){
    
  }

  migrationPattern(e){
    console.log("hello");
    if(e.target.checked)
    {
      console.log("migration pattern rule run!!!");
    }
  }

  cloudProvider(e){
    if(e.target.checked)
    {
      console.log("cloud provider rule run!!!");
    }
  }

  // applicationNameChange(values:any){
  //   console.log("Application name "+values.currentTarget.checked);
  // }

  appIdMethod(e){
    if(e.target.checked)
    {
      console.log("application id!!!");

    }
  }
  
}
