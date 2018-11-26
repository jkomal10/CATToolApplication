import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  clientNameValue : String;
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

  CollectData(){
    this.clientNameValue=this.myStorage.getCurrentUserObject().clientName;
    const reassessUrl = 'http://localhost:8090/application/getAllReassessment';
    return this.http.get(reassessUrl+`/`+this.clientNameValue);
    }

  cloudProvider(applicationId : number){
    const cloudProviderUrl = 'http://localhost:8090/application/cloudProviderCheck';
    console.log(cloudProviderUrl+`/`+applicationId);
    return this.http.get(cloudProviderUrl+`/`+applicationId);
  }

  migrationPattern(applicationId : number){
    const migrationPatternUrl = 'http://localhost:8090/application/migrationCheck';
    console.log(migrationPatternUrl+`/`+applicationId);
    return this.http.get(migrationPatternUrl+`/`+applicationId);
  }
}
