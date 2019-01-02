import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';
import { AssessmentQuestions } from '../../assessment-questions/update-question/Question';
import { IQuestions } from '../../assessment-questions/QuestionsInterface';

@Injectable({
  providedIn: 'root'
})
export class ForMigrationPatternService {
  clientIdValue : number;

  constructor(private http: HttpClient,private myStorage:LocalStorageService) { }

  getAllMigrationData() {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return  this.http.get(this.myStorage.getdomainURL()+`/migrationRule/getAll/`+this.clientIdValue);
  }

  getAssessmentQuestions(){
    return  this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllQuestions`);
  }

  getMigrationQuestions(migrationId : number){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return  this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllMigrationPattern/${migrationId}/${this.clientIdValue}`);
  }

  updateMigrationRule(value: any):Observable<Object>{
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.put(this.myStorage.getdomainURL()+`/migrationRule/updateMigrationRule/`+this.clientIdValue, value);
  }

  saveEvaluationOrder(migration: Object): Observable<Object> {
    return this.http.post(this.myStorage.getdomainURL() + `/migrationRule/setExceutionOrder/create`, migration);
  }

  private comptransfer = new BehaviorSubject("migration pattern");
  question = this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage){
      this.comptransfer.next(messsage);
  } 

  getAllmigrationRules()
  {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(this.myStorage.getdomainURL() +`/migrationRule/getAllMigrationRule/`+ this.clientIdValue);
  }
}
