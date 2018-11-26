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
   deleteAppUrl:String = 'http://localhost:8090/application/deleteApplicationById';
   resetAppUrl:String ='http://localhost:8090/application/resetApplicationById';
   updateAppUrl:String= 'http://localhost:8090/application/updateApplictaion';
   appCountUrl:string = "http://localhost:8090/application/getTotalApplicationsCount";
   CollectData(clientName : string){
    const url = 'http://localhost:8090/application/getAll';
    return this.http.get(url+`/`+clientName);
    }

    baseUrl: string = 'http://localhost:8090/application/saveApplication';
  
    createApplication(application: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}` + `/create`, application);
    }

    deleteApplications(applicationId: number): Observable<any> {
      return this.http.delete(`${this.deleteAppUrl}/${applicationId}`, { responseType: 'text' });
    }

    resetApplication(applicationId: number): Observable<any> {
      return this.http.put(`${this.resetAppUrl}/${applicationId}`, { responseType: 'text' });
    }
    
    updateApplication(value: any): Observable<Object> {
      console.log('################application.service.');
      console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~'+`${this.updateAppUrl}`+'~~~~~~~~~~~~~~~~~~~~~~~');
      return this.http.put(`${this.updateAppUrl}`, value);
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
    getApplicationCount(clientName:string): Observable<any>{
      return this.http.get(`${this.appCountUrl}/${clientName}`);
    }
    
   
}
