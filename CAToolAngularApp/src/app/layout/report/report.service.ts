import { Injectable } from '@angular/core';
import { Component, Input } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient, private myStorage:LocalStorageService) { }

  summaryReport() {
    return  this.http.get(this.myStorage.getdomainURL()+`/application/summaryReport`);
  }

}
