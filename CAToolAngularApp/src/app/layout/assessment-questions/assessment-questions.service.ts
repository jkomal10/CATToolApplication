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

  getAllQuestions(clientId : number) {
    console.log(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllQuestions/`+clientId);
    return  this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllQuestions/`+clientId);
  }

  deleteQuestion(questionId: number): Observable<any> {
    return this.http.delete(this.myStorage.getdomainURL()+`/assessmentQuestions/deleteQuestions/`+questionId, {
      responseType: 'text' 
    });
  }

  updateQuestions(question: Object): Observable<Object> {
    return this.http.put(this.myStorage.getdomainURL() + `/assessmentQuestions/updateQuestions/update`, question);
  }

  private  comptransfer  =  new  BehaviorSubject("Assessment Questions");
  question  =  this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage) {
    this.comptransfer.next(messsage);
  }

  getMigrationData(){
    this.clienIdValue=this.myStorage.getCurrentUserObject().clientId;
    return  this.http.get(this.myStorage.getdomainURL()+`/migrationRule/getAll/`+this.clienIdValue);
  }

  getCloudProviderData(){
    this.clienIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(this.myStorage.getdomainURL()+`/cloudProvider/getAll/`+this.clienIdValue);
  }

  createQuestionn(question: Object): Observable<Object> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8'); 
    return this.http.post(this.myStorage.getdomainURL() + `/assessmentQuestions/saveAssessmentQuestions/create`,question);
  }
  
  updateAssessmentQuestions(value: any): Observable<Object> {
    return this.http.put(this.myStorage.getdomainURL+`/assessmentQuestions/updateQuestions/update`, value);
  }


}