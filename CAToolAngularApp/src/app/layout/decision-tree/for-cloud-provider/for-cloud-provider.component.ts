import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { ForCloudProviderService } from './for-cloud-provider.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CloudProvider } from './CloudProvider';


@Component({
  selector: 'app-for-cloud-provider',
  templateUrl: './for-cloud-provider.component.html',
  styleUrls: ['./for-cloud-provider.component.scss']
})
export class ForCloudProviderComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  cloudProvider : CloudProvider;
   value1: string;

  AllData : any = [];
  constructor(private forCloudProviderService : ForCloudProviderService,public router: Router,private http: HttpClient) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true};
      this.forCloudProviderService.CollectData().subscribe(result => 
        {
        this.AllData = result ;
        this.dtTrigger.next();
        });
  }


  setEvaluationOrder(){
    this.router.navigate(['/for-cloud-provider/app-set-evaluation-order']);
  }

  action(cloudProvider){
 
    console.log(cloudProvider.cloudProviderId);
    this.forCloudProviderService.sendCloudProviderIdtoOtherComponent(cloudProvider.cloudProviderId);
    this.router.navigate(['/for-cloud-provider/app-cloud-provider-rule']);

  }

}
