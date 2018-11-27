import { Component, Input } from '@angular/core';
import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { IUser } from './user';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable()
export class AssessmentQuestionsService {
  clienIdValue: number;
  constructor(private http: HttpClient, private myStorage: LocalStorageService) {

  }
  private getAllQuestionsURL='http://localhost:8090/assessmentQuestions/getAllQuestions';
  private baseUrl = 'http://localhost:8090/assessmentQuestions/deleteQuestions';
  private updateUrl = 'http://localhost:8090/assessmentQuestions/updateQuestions/update';
  private addUrl = 'http://localhost:8090/assessmentQuestions/saveAssessmentQuestions';
  private addUrl1= 'http://localhost:8090/assessmentQuestions/saveAssessmentQuestions';

  getAllQuestions(clientId : number) {
    return  this.http.get(this.getAllQuestionsURL+`/`+clientId);
  }

  deleteQuestion(questionId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${questionId}`, {
      responseType: 'text' 
    });
  }

  updateQuestions(question: Object): Observable<Object> {
    return this.http.put(`${this.updateUrl}`, + `/update`, question);
  }

  private  comptransfer  =  new  BehaviorSubject("Hello");
  question  =  this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage) {
    this.comptransfer.next(messsage);
  }

  getMigrationData(){
    this.clienIdValue=this.myStorage.getCurrentUserObject().clientId;
    const  url  =  'http://localhost:8090/migrationRule/getAll';
    return  this.http.get(url+`/`+this.clienIdValue);
  }

  getCloudProviderData(){
    this.clienIdValue=this.myStorage.getCurrentUserObject().clientId;

    const url = 'http://localhost:8090/cloudProvider/getAll';
    return this.http.get(url+`/`+this.clienIdValue);
  }

  createQuestionn(question: Object): Observable<Object> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8'); 
    return this.http.post(`${this.addUrl1}` + `/create`,question);
  }
  
  updateAssessmentQuestions(value: any): Observable<Object> {
    return this.http.put(`${this.updateUrl}`, value);
  }


}