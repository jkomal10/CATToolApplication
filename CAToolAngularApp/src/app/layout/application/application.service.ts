import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  
  constructor(private http:HttpClient) { }
  
  CollectData(){
     const url = 'http://localhost:8090/application/getAll';
    return this.http.get(url);
    }

    // createApplication(application: Object): Observable<Object> {
    //   return this.http.post(`${this.baseUrl}` + `/create`, application);
    // }
    
}
