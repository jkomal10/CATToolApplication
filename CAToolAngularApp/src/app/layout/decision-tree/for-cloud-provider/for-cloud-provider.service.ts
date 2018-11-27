import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }
  clientIdValue : number;
  
    
CollectData(){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(this.myStorage.getdomainURL()+`/cloudProvider/getAll/`+this.clientIdValue);
  }


  saveEvaluationOrder(evaluationOrder: Object): Observable<Object> 
  {
    return this.http.put(this.myStorage.getdomainURL()+`/cloudProvider/setEvaluationOrder`,evaluationOrder);
  }

  private  comptransfer  =  new  BehaviorSubject("cloud provider");
  cloudProviderId  =  this.comptransfer.asObservable();

  sendCloudProviderIdtoOtherComponent(messsage)
  {
    this.comptransfer.next(messsage);
  }

  CollectCloudableRuleQuestions(cloudproviderId : number){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllCloudProviderRule/`+cloudproviderId+`/`+this.clientIdValue);
  }
  updateCloudProviderRule(cloudableRule:any):Observable<Object>
  {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.put(this.myStorage.getdomainURL()+`/cloudProvider/updateCloudProviderRule`+`/`+this.clientIdValue, cloudableRule);
  }
}
