import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { ForCloudProviderService } from '../for-cloud-provider.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-set-evaluation-order',
  templateUrl: './set-evaluation-order.component.html',
  styleUrls: ['./set-evaluation-order.component.scss']
})
export class SetEvaluationOrderComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
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

    this.forCloudProviderService.saveEvaluationOrder(this.AllData).subscribe();
  }

}
