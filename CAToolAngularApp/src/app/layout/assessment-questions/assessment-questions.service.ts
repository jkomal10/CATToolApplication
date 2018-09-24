import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IUser} from './user';

@Injectable()
export class AssessmentQuestionsService {

  private getUserByID_url: string = "http://localhost:8090/user/findByusername/";

    constructor(private http: HttpClient) {
       
     }

     CollectData(){
        const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
        console.log('*********************************************'+url+'***********************');
        return this.http.get(url);
        }
}