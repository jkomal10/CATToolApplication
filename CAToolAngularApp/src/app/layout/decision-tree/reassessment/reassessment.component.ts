import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ServiceService } from './reassessment.service';

@Component({
  selector: 'app-reassessment',
  templateUrl: './reassessment.component.html',
  styleUrls: ['./reassessment.component.scss']
})
export class ReassessmentComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  value1: string;
  reassessmentDataValue: any = [];
  applicationId: number;
  applicationIdArray: any = [];
  migrationCheckbox: boolean;
  cloudProviderCheckbox: boolean;
  i: number = 0;
  j: number = 0;

  constructor(public router: Router, private reassessmentService: ServiceService, private http: HttpClient) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      responsive: true
    };
    this.reassessmentService.reassessmentData().subscribe(result => {
      this.reassessmentDataValue = result ;
      this.dtTrigger.next();
    });


  }

  runRule() {
    for (let index = 0; index < this.applicationIdArray.length; index++) {

      if (this.cloudProviderCheckbox) {
        this.reassessmentService.cloudProvider(this.applicationIdArray[index]).subscribe();
      }

      if (this.migrationCheckbox) {
        this.reassessmentService.migrationPattern(this.applicationIdArray[index]).subscribe();
      }

    }
  }

  migrationPatternMethod(values: any) {
    this.migrationCheckbox = values.currentTarget.checked;
  }

  cloudProviderMethod(values: any) {
    this.cloudProviderCheckbox = values.currentTarget.checked;
  }

  applicationNameChange(e, applicationId) {
    if (e.currentTarget.checked) {

      this.applicationIdArray[this.i] = applicationId;
      this.i++;
    }
    else {
      for (let index = 0; index < this.applicationIdArray.length; index++) {

        if (this.applicationIdArray[index] == applicationId) {
          this.applicationIdArray.splice(index, 1);
        }
      }
    }
  }
}
