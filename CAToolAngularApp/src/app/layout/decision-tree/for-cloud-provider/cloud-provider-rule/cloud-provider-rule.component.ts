import { Component, OnInit } from '@angular/core';
import { ForCloudProviderService } from '../for-cloud-provider.service';
import { CloudProviderRule } from '../CloudProviderRule';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
@Component({
  selector: 'app-cloud-provider-rule',
  templateUrl: './cloud-provider-rule.component.html',
  styleUrls: ['./cloud-provider-rule.component.scss']
})
export class CloudProviderRuleComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  cloudproviderId : any;
  CloudProviderAllData : any;
  executionOrders : Array<number> = [];
  cloudProviderRulesText : Array<string> = [];
  cloudProviderRule : Array<CloudProviderRule> = [];
  constructor(private forCloudProviderService:ForCloudProviderService,public router: Router) { }

  

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};
    this.forCloudProviderService.cloudProviderId.subscribe(data=>{this.cloudproviderId=data;});
      this.forCloudProviderService.CollectCloudableRuleQuestions(this.cloudproviderId).subscribe( result=>{
      this.CloudProviderAllData = result;
      this.dtTrigger.next();
    });
  }

  onSubmit(){
    this.addCloudeProviderRule();
    
  }

  addCloudeProviderRule(){
    for (let index = 0; index < this.CloudProviderAllData.length; index++) {
      
      var cloudproRules : CloudProviderRule = new CloudProviderRule();
        cloudproRules.questionId = this.CloudProviderAllData[index].questionId;
        cloudproRules.cloudProviderId = this.cloudproviderId;
        cloudproRules.cloudProviderRule = this.cloudProviderRulesText[index];
        cloudproRules.executionOrder = this.executionOrders[index];
        cloudproRules.questionText = this.CloudProviderAllData[index].questionText;
       
      for (let index1 = 0; index1 < this.CloudProviderAllData[index].cloudProviderRules.length; index1++) {
       
        if(this.CloudProviderAllData[index].cloudProviderRules[index1].cloudProviderId===this.cloudproviderId)
        {
          cloudproRules.cloudProviderRuleId=this.CloudProviderAllData[index].cloudProviderRules[index1].cloudProviderRuleId;
        }
        
      }
      this.cloudProviderRule[index]= cloudproRules; 
    }
    console.log(JSON.stringify(this.cloudProviderRule));
    this.forCloudProviderService.updateCloudProviderRule(this.cloudProviderRule).subscribe();
    this.router.navigate(['/for-cloud-provider']);
  }

  Cancel(){
    this.router.navigate(['/for-cloud-provider']);
  }

  addQuestion(){
    this.router.navigate(['/assessment-questions/add-assessment-question']);
  }
  
}
