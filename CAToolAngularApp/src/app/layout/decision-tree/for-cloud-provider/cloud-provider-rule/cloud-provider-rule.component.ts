import { Component, OnInit } from '@angular/core';
import { ForCloudProviderService } from '../for-cloud-provider.service';
import { CloudProviderRule } from '../CloudProviderRule';
import { Router } from '../../../../../../node_modules/@angular/router';
import { Subject } from 'rxjs';
@Component({
  selector: 'app-cloud-provider-rule',
  templateUrl: './cloud-provider-rule.component.html',
  styleUrls: ['./cloud-provider-rule.component.scss']
})
export class CloudProviderRuleComponent implements OnInit {

  // dtOptions: DataTables.Settings = {};
  // dtTrigger: Subject<any> = new Subject();
  cloudproviderId : any;
  CloudProviderAllData : any;
  executionOrders : Array<number> = [];
  cloudProviderRulesText : Array<string> = [];
  cloudProviderRule : Array<CloudProviderRule> = [];
  constructor(private forCloudProviderService:ForCloudProviderService,public router: Router) { }

  

  ngOnInit() {
    this.forCloudProviderService.cloudProviderId.subscribe(data=>{this.cloudproviderId=data;});
    console.log(this.cloudproviderId+"Cloud Provider rule component");

    // this.forCloudProviderService.CollectCloudableRuleQuestions(this.cloudproviderId).subscribe( result=>{
      this.forCloudProviderService.CollectCloudableRuleQuestions(this.cloudproviderId).subscribe( result=>{
      this.CloudProviderAllData = result;
      console.log(this.CloudProviderAllData);
      // for (let index = 0; index < this.CloudProviderAllData.length; index++) {
      //   for (let index1 = 0; index1 < this.CloudProviderAllData[index].cloudProviderRules.length; index1++) {
      //     this.executionOrdersCp[index1] = this.CloudProviderAllData[index].cloudProviderRules[index1].executionOrder;
      //      console.log("**this.executionOrdersCp"+this.executionOrdersCp[index1]);

      //   }
      // }
      console.log("*****CloudProviderAllData");
      console.log("&&&&&&"+this.executionOrders);
    });

    

     console.log("the cloudproviderid is "+this.cloudproviderId);
    // console.log("the providerid we get "+ this.CloudProviderAllData.cloudProviderRules[0].cloudProviderRuleId);
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
  
}
