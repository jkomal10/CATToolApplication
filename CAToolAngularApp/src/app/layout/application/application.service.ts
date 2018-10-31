import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Observable, BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  
  constructor(private http:HttpClient) { }
  deactivateUrl:String ='http://localhost:8090/application/deactivateApplicationById';
   Baseurl:String = 'http://localhost:8090/application/deleteApplicationById';
   deleteUrl:String ='http://localhost:8090/application/resetApplicationById';
  //url:String= 'http://localhost:8090/application/getApplicationById';
  url1:String= 'http://localhost:8090/application/updateApplictaion';
  CollectData(){
    const url = 'http://localhost:8090/application/getAll';
    return this.http.get(url);
    }

    baseUrl: string = 'http://localhost:8090/application/saveApplication';
  
    createApplication(application: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}` + `/create`, application);
    }

    deleteApplications(applicationId: number): Observable<any> {
      return this.http.delete(`${this. Baseurl}/${applicationId}`, { responseType: 'text' });
    }

    resetApplication(applicationId: number): Observable<any> {
      return this.http.put(`${this. deleteUrl}/${applicationId}`, { responseType: 'text' });
    }
    
    updateApplication(value: any): Observable<Object> {
      console.log('################application.service.');
      console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~'+`${this.url1}`+'~~~~~~~~~~~~~~~~~~~~~~~');
      return this.http.put(`${this.url1}`, value);
    }

    deactivate(applicationId: number): Observable<any> {
      console.log('################application.service.');
      console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~'+`${this.deactivateUrl}`+'~~~~~~~~~~~~~~~~~~~~~~~');
      return this.http.put(`${this.deactivateUrl}/${applicationId}`,  { responseType: 'text' });
    }

    private comptransfer = new BehaviorSubject("Hello");
    question = this.comptransfer.asObservable();
  
    sendMsgtoOtherComponent(messsage){
        this.comptransfer.next(messsage);
    } 
    
   
}
