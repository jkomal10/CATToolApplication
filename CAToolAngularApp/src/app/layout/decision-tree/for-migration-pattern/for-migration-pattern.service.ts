import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ForMigrationPatternService {
  clientIdValue : number;
  private migrationUrl = 'http://localhost:8090/migrationRule/setExceutionOrder';
  private updateMigrationRuleUrl = 'http://localhost:8090/migrationRule/updateMigrationRule';

  constructor(private http: HttpClient,private myStorage:LocalStorageService) { }
  CollectData() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    const  url  =  'http://localhost:8090/migrationRule/getAll';
    return  this.http.get(url+`/`+this.clientIdValue);
  }

  getAssessmentQuestions(){
    const  url  =  'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return  this.http.get(url);
  }

  getMigrationQuestions(migrationId : number){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return  this.http.get(`http://localhost:8090/assessmentQuestions/getAllMigrationPattern/${migrationId}/${this.clientIdValue}`);
  }

  updateMigrationRule(value: any):Observable<Object>{
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.put(`${this.updateMigrationRuleUrl}`+`/`+this.clientIdValue, value);
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
