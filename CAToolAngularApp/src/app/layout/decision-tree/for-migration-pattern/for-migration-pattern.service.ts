import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForMigrationPatternService {

  private migrationUrl = 'http://localhost:8090/migrationRule/setExceutionOrder';

  constructor(private http: HttpClient) { }
  CollectData() {
    const  url  =  'http://localhost:8090/migrationRule/getAll';
    return  this.http.get(url);
  }

  getAssessmentQuestions(){
    const  url  =  'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return  this.http.get(url);
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
