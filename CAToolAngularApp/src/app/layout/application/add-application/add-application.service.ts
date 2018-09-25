import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AddApplicationService {

  constructor( private http:HttpClient) { }
  baseUrl: string = 'http://localhost:8090/application/saveApplication';
  
  createApplication(application: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, application);
  }
}
