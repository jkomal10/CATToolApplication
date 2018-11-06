import { Component, OnInit } from '@angular/core';
import { ForMigrationPatternService } from '../for-migration-pattern.service';
import { Router } from '../../../../../../node_modules/@angular/router';
import { HttpClient } from '@angular/common/http';
import { CloudProviderRule } from '../../../assessment-questions/CloudProviderRule';
import { MigrationRule } from '../../../assessment-questions/MigrationRule';


@Component({
  selector: 'app-migration-patterns',
  templateUrl: './migration-patterns.component.html',
  styleUrls: ['./migration-patterns.component.scss']
})
export class MigrationPatternsComponent implements OnInit {
  migrationRuleObject: Array<MigrationRule> = [];
  
  migrationAllData : any = [];
  migrationOption : any =[];
  migrationRule : Array<string>=[];
  executionOrderValue :Array<number>=[];
  constructor(private forMigrationPatternService : ForMigrationPatternService,public router: Router,private http: HttpClient) { }
  migrationIdValue : any;
  
  ngOnInit() {
    this.forMigrationPatternService.question.subscribe(data => {this.migrationIdValue= data;});
    this.forMigrationPatternService.getMigrationQuestions(this.migrationIdValue).subscribe(result => 
      {
      this.migrationAllData= result ;
      });
  }

  migrationProviderMethod(){
    console.log(JSON.stringify(this.migrationAllData));
    for(let index = 0; index < this.migrationAllData.length; index++){
        var migrationRuleNewObject:MigrationRule=new MigrationRule();
        migrationRuleNewObject.questionId=this.migrationAllData[index].questionId;
        migrationRuleNewObject.migrationId= this.migrationIdValue;
        migrationRuleNewObject.migrationRule= this.migrationRule[index];
        console.log(this.executionOrderValue[index]+"***********%%%%%%%%%%%%%******************");
        migrationRuleNewObject.executionOrder = this.executionOrderValue[index];
        migrationRuleNewObject.questionText = this.migrationAllData[index].questionText;
        for(let i=0;i<this.migrationAllData[index].migrationRule.length;i++)
        {
          if(this.migrationAllData[index].migrationRule[i].migrationId===this.migrationIdValue)
          {
            migrationRuleNewObject.migrationRuleId=this.migrationAllData[index].migrationRule[i].migrationRuleId;
          }
       }
        this.migrationRuleObject[index]=migrationRuleNewObject;    
        
    }
    this.forMigrationPatternService.updateMigrationRule(this.migrationRuleObject).subscribe();
    this.router.navigate(['/for-migration-pattern']);
    
  }

  Cancel(){
    this.router.navigate(['/for-migration-pattern']);
  }

}