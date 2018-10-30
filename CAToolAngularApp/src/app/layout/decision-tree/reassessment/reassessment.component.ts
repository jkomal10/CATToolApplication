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
  applicationIdArray : any = [];
  migrationCheckbox : boolean;
  cloudProviderCheckbox : boolean;
  i : number=0;
  j : number=0;

  constructor(public router:Router,private reassessmentService:ServiceService,private http:HttpClient) { }

  ngOnInit() {

    this.reassessmentService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      });

    
  }

  runRule(){
    console.log("run rules++++++++++++++++");
    for (let index = 0; index < this.applicationIdArray.length ; index++) {
      console.log(this.applicationIdArray[index]);
      console.log("^^^"+this.migrationCheckbox+"^^^^");

      if(this.cloudProviderCheckbox)
      {
          console.log("cloud provider clicked");
          this.reassessmentService.cloudProvider(this.applicationIdArray[index]).subscribe();
      }

      if(this.migrationCheckbox)
      {
          console.log("migration clicked");
          this.reassessmentService.migrationPattern(this.applicationIdArray[index]).subscribe();
      }

    } 
  }

  migrationPatternMethod(values:any){
    console.log("migration "+values.currentTarget.checked)
    this.migrationCheckbox=values.currentTarget.checked;
  }

  cloudProviderMethod(values:any){
    console.log("cloud provider "+values.currentTarget.checked);
    this.cloudProviderCheckbox=values.currentTarget.checked;
  }

  applicationNameChange(e,applicationId){
    if(e.currentTarget.checked)
    {

      this.applicationIdArray[this.i]=applicationId;
      console.log(this.applicationIdArray[this.i]);
      this.i++;
      console.log(this.i);
    }
    else{
      for (let index = 0; index < this.applicationIdArray.length ; index++) {

        if(this.applicationIdArray[index]==applicationId)
        {
          this.applicationIdArray.splice(index, 1);
        }
      }
    }
  }
}
