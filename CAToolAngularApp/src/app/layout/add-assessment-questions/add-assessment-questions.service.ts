import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IUser} from './user';

@Injectable()
export class AddAssessmentQuestionsService {

  private getUserByID_url: string = "http://localhost:8090/user/findByusername/";

    constructor(private http: HttpClient) {
       
     }
     getUserByID(username : string):Observable<IUser>{
      let headers = new HttpHeaders();
      headers.append("Authorization", "Basic " + btoa("Nirav" + ":" + "password"));
      headers.append('Content-Type', 'application/json; charset=utf-8');
      return this.http.get<IUser>(this.getUserByID_url+username); 
  }
}
