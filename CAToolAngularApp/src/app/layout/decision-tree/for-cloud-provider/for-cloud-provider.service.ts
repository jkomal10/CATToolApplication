import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {

 
  private evaluationOrder = 'http://localhost:8090/cloudProvider';
  private updateCloudProviderRuleUrl="http://localhost:8090/cloudProvider/updateCloudProviderRule";
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }
  clientIdValue : number;
  
    
CollectData(){
  this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
  const url = 'http://localhost:8090/cloudProvider/getAll';
  return this.http.get(url+`/`+this.clientIdValue);
  }


  saveEvaluationOrder(evaluationOrder: Object): Observable<Object> 
  {
    console.log(this.evaluationOrder);
    return this.http.put(`${this.evaluationOrder}`+`/setEvaluationOrder`,evaluationOrder);
  }

  private  comptransfer  =  new  BehaviorSubject("Hello");
  cloudProviderId  =  this.comptransfer.asObservable();

  sendCloudProviderIdtoOtherComponent(messsage)
  {
    this.comptransfer.next(messsage);
  }

  CollectCloudableRuleQuestions(cloudproviderId : number){
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.get(`http://localhost:8090/assessmentQuestions/getAllCloudProviderRule/${cloudproviderId}/${this.clientIdValue}`);
  }
  updateCloudProviderRule(cloudableRule:any):Observable<Object>
  {
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.put(`${this.updateCloudProviderRuleUrl}`+`/`+this.clientIdValue, cloudableRule);
  }
}
