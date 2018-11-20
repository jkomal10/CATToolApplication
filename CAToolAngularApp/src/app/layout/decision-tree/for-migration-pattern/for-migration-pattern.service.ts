import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForMigrationPatternService {
  clientNameValue : String;
  private migrationUrl = 'http://localhost:8090/migrationRule/setExceutionOrder';
  private updateMigrationRuleUrl = 'http://localhost:8090/migrationRule/updateMigrationRule';

  constructor(private http: HttpClient) { }
  CollectData() {
    this.clientNameValue=localStorage.getItem('clientName');
    const  url  =  'http://localhost:8090/migrationRule/getAll';
    return  this.http.get(url+`/`+this.clientNameValue);
  }

  getAssessmentQuestions(){
    const  url  =  'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return  this.http.get(url);
  }

  getMigrationQuestions(migrationId : number){
    this.clientNameValue=localStorage.getItem('clientName');
    return  this.http.get(`http://localhost:8090/assessmentQuestions/getAllMigrationPattern/${migrationId}/${this.clientNameValue}`);
  }

  updateMigrationRule(value: any):Observable<Object>{
    this.clientNameValue=localStorage.getItem('clientName');
    return this.http.put(`${this.updateMigrationRuleUrl}`+`/`+this.clientNameValue, value);
  }

  saveEvaluationOrder(migration: Object): Observable<Object> {
    return this.http.post(`${this.migrationUrl}` + `/create`, migration);
  }

  private comptransfer = new BehaviorSubject("Hello");
  question = this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage){
      this.comptransfer.next(messsage);
  } 
}
