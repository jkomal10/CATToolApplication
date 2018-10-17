import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ForMigrationPatternService } from './for-migration-pattern.service';

@Component({
  selector: 'app-for-migration-pattern',
  templateUrl: './for-migration-pattern.component.html',
  styleUrls: ['./for-migration-pattern.component.scss']
})
export class ForMigrationPatternComponent implements OnInit {

  dtOptions: DataTables.Settings = {};
  AllData : any = [];
  dtTrigger: Subject<any> = new Subject();
  constructor(private forMigrationPatternService : ForMigrationPatternService,public router: Router,private http: HttpClient) { }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      responsive: true};

    this.forMigrationPatternService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      });
  }

}
