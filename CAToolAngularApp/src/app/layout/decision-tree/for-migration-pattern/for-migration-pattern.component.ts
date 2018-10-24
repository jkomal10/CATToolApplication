import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ForMigrationPatternService } from './for-migration-pattern.service';
import { AssessmentQuestions } from './AssessmentQuestions';

@Component({
  selector: 'app-for-migration-pattern',
  templateUrl: './for-migration-pattern.component.html',
  styleUrls: ['./for-migration-pattern.component.scss']
})
export class ForMigrationPatternComponent implements OnInit {
  assessmentQuestions: AssessmentQuestions = new AssessmentQuestions();
  dtOptions: DataTables.Settings = {};
  AllData : any = [];
  constructor(private forMigrationPatternService : ForMigrationPatternService,public router: Router,private http: HttpClient) { }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      responsive: true};

    this.forMigrationPatternService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      console.log(this.AllData);
      });
  }

  questions(index){
    console.log('**************'+index);//rehost
    this.forMigrationPatternService.sendMsgtoOtherComponent(index);
    this.router.navigate(['/for-migration-pattern/migration-patterns']);
  }

  evaluationOrder(){
    this.router.navigate(['/for-migration-pattern/evaluation-order']);
  }

}
