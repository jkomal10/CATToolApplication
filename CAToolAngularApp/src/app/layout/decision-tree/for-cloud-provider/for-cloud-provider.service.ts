import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {

  clientNameValue : String;
  
  private evaluationOrder = 'http://localhost:8090/cloudProvider';
  // private cloudProviderRuleUrl = 'http://localhost:8090/cloudProvider/getAllCloudProviderQuestion';


  private updateCloudProviderRuleUrl="http://localhost:8090/cloudProvider/updateCloudProviderRule";

  constructor(private http:HttpClient) { }

  
    
CollectData(){
  this.clientNameValue=localStorage.getItem('clientName');
  const url = 'http://localhost:8090/cloudProvider/getAll';
  return this.http.get(url+`/`+this.clientNameValue);
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
    this.clientNameValue=localStorage.getItem('clientName');
    return this.http.get(`http://localhost:8090/assessmentQuestions/getAllCloudProviderRule/${cloudproviderId}/${this.clientNameValue}`);
  }
  updateCloudProviderRule(cloudableRule:any):Observable<Object>
  {
    this.clientNameValue=localStorage.getItem('clientName');
    return this.http.put(`${this.updateCloudProviderRuleUrl}`+`/`+this.clientNameValue, cloudableRule);
  }
}
