import { Component, OnInit } from '@angular/core';
import { AssessmentQuestions } from '../AssessmentQuestions';
import { ForMigrationPatternService } from '../for-migration-pattern.service';
import { Router } from '../../../../../../node_modules/@angular/router';
import { HttpClient } from '@angular/common/http';
import { Migration } from '../Migration';

@Component({
  selector: 'app-evaluation-order',
  templateUrl: './evaluation-order.component.html',
  styleUrls: ['./evaluation-order.component.scss']
})
export class EvaluationOrderComponent implements OnInit {
  constructor(private forMigrationPatternService : ForMigrationPatternService,public router: Router,private http: HttpClient) { }
  AllData : any = [];

  ngOnInit() {
    this.forMigrationPatternService.CollectData().subscribe(result => 
      {
      this.AllData = result;
      console.log(this.AllData);
      });


  }

  questions(){
    this.router.navigate(['/for-migration-pattern/public-pass']);
  }

  saveEvaluationOrder(){
    console.log('*************************'+JSON.stringify(this.AllData));
    this.forMigrationPatternService.saveEvaluationOrder(this.AllData).subscribe();
  }

}
