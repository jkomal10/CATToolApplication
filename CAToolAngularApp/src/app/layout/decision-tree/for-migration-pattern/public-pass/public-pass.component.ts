import { Component, OnInit } from '@angular/core';
import { AssessmentQuestions } from '../AssessmentQuestions';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { PublicPassService } from './public-pass.service';
import { ForMigrationPatternService } from '../for-migration-pattern.service';

@Component({
  selector: 'app-public-pass',
  templateUrl: './public-pass.component.html',
  styleUrls: ['./public-pass.component.scss']
})
export class PublicPassComponent implements OnInit {
  assessmentQuestions: AssessmentQuestions = new AssessmentQuestions();

  AllData : any = [];
  que : number;
  patternValue : string;
  public name="pppp";

  constructor(private forMigrationPatternService:ForMigrationPatternService,private publicPassService:PublicPassService,public router: Router,private http: HttpClient) { }

  ngOnInit() {
    this.forMigrationPatternService.question.subscribe(data => {this.patternValue= data;}); 
    this.que=10;
    this.publicPassService.CollectData().subscribe(result => 
      {  
          this.AllData = result ;
      });
    
  }

}
