import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IUser} from './user';

@Injectable()
export class AssessmentQuestionsService {
    constructor(private http: HttpClient) {
       
     }

     private baseUrl='http://localhost:8090/assessmentQuestions/deleteQuestions';

     CollectData(){
        const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
        return this.http.get(url);
        }

        deleteQuestion(questionId: number): Observable<any> {
            return this.http.delete(`${this.baseUrl}/${questionId}`, { responseType: 'text' });
          }
}