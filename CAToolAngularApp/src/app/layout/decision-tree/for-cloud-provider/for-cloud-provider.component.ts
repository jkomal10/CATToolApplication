import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { ForCloudProviderService } from './for-cloud-provider.service';

@Component({
  selector: 'app-for-cloud-provider',
  templateUrl: './for-cloud-provider.component.html',
  styleUrls: ['./for-cloud-provider.component.scss']
})
export class ForCloudProviderComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  AllData : any = [];
  constructor(private forCloudProviderService : ForCloudProviderService) { }

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

}
