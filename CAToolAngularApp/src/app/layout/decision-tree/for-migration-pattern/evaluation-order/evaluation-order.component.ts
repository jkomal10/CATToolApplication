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
  migrationData : any = [];

  ngOnInit() {
    this.forMigrationPatternService.getAllMigrationData().subscribe(result => 
      {
        this.migrationData = result;
      });
  }

  questions(){
    this.router.navigate(['/for-migration-pattern/public-pass']);
  }

  saveEvaluationOrder(){
    this.forMigrationPatternService.saveEvaluationOrder(this.migrationData).subscribe();
  }

}
