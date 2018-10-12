import { Component, Input } from '@angular/core';
import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { IUser } from './user';

@Injectable()
export class AssessmentQuestionsService {
  constructor(private http: HttpClient) {

  }
  private baseUrl = 'http://localhost:8090/assessmentQuestions/deleteQuestions';
  private updateUrl = 'http://localhost:8090/assessmentQuestions/updateQuestions/update';
  private addUrl = 'http://localhost:8090/assessmentQuestions/saveAssessmentQuestions';
  private addUrl1 ='http://localhost:8090/option/save';

  CollectData() {
    const  url  =  'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return  this.http.get(url);
  }

  deleteQuestion(questionId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${questionId}`, { responseType: 'text' });
  }

  updateQuestions(question: Object): Observable<Object> {
    return this.http.put(`${this.updateUrl}`, + `/update`, question);
  }

  private  comptransfer  =  new  BehaviorSubject("Hello");
  question  =  this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage) {
    this.comptransfer.next(messsage);
  }

  createQuestion(question: Object): Observable<Object> {
    return this.http.post(`${this.addUrl}` + `/create`, question);
  }
  createOption(option: Object): Observable<Object> {
    // let headers = new Headers({ 'Content-Type': 'application/json' });
    // let options = new RequestOptions({ headers: headers });
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8'); 
    console.log(JSON.stringify(option));
    return this.http.post(`${this.addUrl1}` + `/create`, JSON.stringify(option),{headers:headers});
  }
  
  updateAssessmentQuestions(value: any): Observable<Object> {
    console.log('################assessmentQuestions.service.');
    console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~' + `${this.updateUrl}` + '~~~~~~~~~~~~~~~~~~~~~~~');
    return this.http.put(`${this.updateUrl}`, value);
  }


}