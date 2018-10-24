import { Component, OnInit } from '@angular/core';
import { ForCloudProviderService } from '../for-cloud-provider.service';

@Component({
  selector: 'app-cloud-provider-rule',
  templateUrl: './cloud-provider-rule.component.html',
  styleUrls: ['./cloud-provider-rule.component.scss']
})
export class CloudProviderRuleComponent implements OnInit {

  cloudproviderId : any;
  AllData : any;
  constructor(private forCloudProviderService:ForCloudProviderService) { }

  ngOnInit() {
    this.forCloudProviderService.cloudProviderId.subscribe(data=>{this.cloudproviderId=data;});
    console.log(this.cloudproviderId+"Cloud Provider rule component");

    this.forCloudProviderService.CollectCloudableRuleQuestions(this.cloudproviderId).subscribe( result=>{
      
      this.AllData = result;
      console.log(this.AllData);
    })
  }



  
  
}
