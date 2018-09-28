import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from './Application';
import { Observable, BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  
  constructor(private http:HttpClient) { }
   Baseurl:String = 'http://localhost:8090/application/deleteApplicationById';
  //url:String= 'http://localhost:8090/application/getApplicationById';
  url1:String= 'http://localhost:8090/application/updateApplictaion';
  CollectData(){
    const url = 'http://localhost:8090/application/getAll';
    return this.http.get(url);
    }

    deleteApplications(applicationId: number): Observable<any> {
      return this.http.delete(`${this. Baseurl}/${applicationId}`, { responseType: 'text' });
    }
    
    // getAppById(id: number) {
    //   return this.http.get<Application>(this.url1 + '/' + id);
    // }
    // updateUser(application: Application) {
    //   return this.http.put(this. Baseurl + '/' + application.applicationId, application);
    // }
    updateApplication(value: any): Observable<Object> {
      console.log('################application.service.');
      console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~'+`${this.url1}`+'~~~~~~~~~~~~~~~~~~~~~~~');
      return this.http.put(`${this.url1}`, value);
    }

    private comptransfer = new BehaviorSubject("Hello");
question = this.comptransfer.asObservable();

sendMsgtoOtherComponent(messsage){
this.comptransfer.next(messsage);
} 
    
}
