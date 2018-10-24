import { Component, OnInit } from '@angular/core';
import { ForMigrationPatternService } from '../for-migration-pattern.service';
import { Router } from '../../../../../../node_modules/@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-migration-patterns',
  templateUrl: './migration-patterns.component.html',
  styleUrls: ['./migration-patterns.component.scss']
})
export class MigrationPatternsComponent implements OnInit {
  migrationAllData : any = [];

  constructor(private forMigrationPatternService : ForMigrationPatternService,public router: Router,private http: HttpClient) { }
  patternValue : any;

  ngOnInit() {
    this.forMigrationPatternService.getAssessmentQuestions().subscribe(result => 
      {
      this.migrationAllData= result ;
      console.log(this.migrationAllData);
      console.log(JSON.stringify(this.migrationAllData));
      });
    this.forMigrationPatternService.question.subscribe(data => {this.patternValue= data;}); 
    console.log(this.patternValue);
  }

}