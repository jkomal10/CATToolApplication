import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  clientIdValue : number;
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

  reassessmentData(){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(this.myStorage.getdomainURL()+`/application/getAllReassessment/`+this.clientIdValue);
    }

  cloudProvider(applicationId : number){
    return this.http.get(this.myStorage.getdomainURL()+`/application/cloudProviderCheck/`+applicationId);
  }

  migrationPattern(applicationId : number){
    return this.http.get(this.myStorage.getdomainURL()+`/application/migrationCheck/`+applicationId);
  }
}
