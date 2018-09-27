import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from '../Application';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewApplicationService {
  url:String ='http://localhost:8090/application/getApplicationById';
  constructor(private http:HttpClient) { }
  CollectSingleApplicationData(applicationId: number): Observable<any>{
    
    return this.http.get(`${this.url}/${applicationId}`, { responseType: 'text' });
    
  }
}
