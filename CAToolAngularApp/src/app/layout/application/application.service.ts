import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../utility/service/localStorage.service';
@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

   getAllAplication(clientId : number): Observable<Object>{
     console.log("**********************************"+this.myStorage.getdomainURL() );
      return this.http.get(this.myStorage.getdomainURL()+`/application/getAll/`+clientId);
    }

    getAllFinalizeAplication(clientId : number,fromDate:Date,toDate:Date): Observable<Object>{
      console.log("**********************************"+this.myStorage.getdomainURL() );
       return this.http.get(this.myStorage.getreportURL()+`/assessment/report/getAllFinalizeAplication/`+clientId+`/`+fromDate+`/`+toDate);
     }
  
    createApplication(application: Object): Observable<Object> {
      return this.http.post(this.myStorage.getdomainURL() + `/application/saveApplication/create`, application);
    }

    deleteApplications(applicationId: number): Observable<any> {
      return this.http.delete(this.myStorage.getdomainURL()+`/application/deleteApplicationById/`+applicationId, { responseType: 'text' });
    }

    resetApplication(applicationId: number): Observable<any> {
      return this.http.put(this.myStorage.getdomainURL()+`/application/resetApplicationById/`+applicationId, { responseType: 'text' });
    }
    
    updateApplication(value: any): Observable<Object> {
      return this.http.put(this.myStorage.getdomainURL()+`/application/updateApplictaion/`+this.myStorage.getClientName() ,value);
    }

    deactivate(applicationId: number): Observable<any> {
      return this.http.put(this.myStorage.getdomainURL()+`/application/deactivateApplicationById/`+applicationId,  { responseType: 'text' });
    }

    private comptransfer = new BehaviorSubject("Hello");
    question = this.comptransfer.asObservable();
  
    sendMsgtoOtherComponent(messsage){
        this.comptransfer.next(messsage);
    } 
    getApplicationCount(clientId:number): Observable<any>{
      return this.http.get(this.myStorage.getdomainURL()+`/application/getTotalApplicationsCount/`+clientId);
    }
    
   
}
