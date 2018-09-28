import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentQuestionsService } from '../../assessment-questions/assessment-questions.service';
import { Subject } from 'rxjs';
import { Question } from './Question';

@Component({
  selector: 'app-assesst-application',
  templateUrl: './assesst-application.component.html',
  styleUrls: ['./assesst-application.component.scss']
})
export class AssesstApplicationComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  AllData : any = [];
  constructor(private router:Router,private questionService:AssessmentQuestionsService) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      responsive: true}; 

   this.questionService.CollectData().subscribe(result => 
      {
      this.AllData = result ;
      this.dtTrigger.next();
      console.log(this.AllData);
      });
   } 

}
