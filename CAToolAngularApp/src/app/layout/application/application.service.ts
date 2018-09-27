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
  CollectData(){
    const url = 'http://localhost:8090/application/getAll';
    return this.http.get(url);
    }

    deleteApplications(applicationId: number): Observable<any> {
      return this.http.delete(`${this. Baseurl}/${applicationId}`, { responseType: 'text' });
    }
    
    private comptransfer = new BehaviorSubject("Hello");
question = this.comptransfer.asObservable();

sendMsgtoOtherComponent(messsage:string){
this.comptransfer.next(messsage);
} 
    
}
