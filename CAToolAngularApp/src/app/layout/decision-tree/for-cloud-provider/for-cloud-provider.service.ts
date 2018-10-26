import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {

  private evaluationOrder = 'http://localhost:8090/cloudProvider';
  // private cloudProviderRuleUrl = 'http://localhost:8090/cloudProvider/getAllCloudProviderQuestion';


  private updateCloudProviderRuleUrl="http://localhost:8090/cloudProvider/updateCloudProviderRule";

  constructor(private http:HttpClient) { }

  
    
CollectData(){
  const url = 'http://localhost:8090/cloudProvider/getAll';
  return this.http.get(url);
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
   
    return this.http.get(`http://localhost:8090/assessmentQuestions/getAllCloudProviderRule/${cloudproviderId}`);
  }
  updateCloudProviderRule(cloudableRule:any):Observable<Object>
  {
    return this.http.put(`${this.updateCloudProviderRuleUrl}`, cloudableRule);
  }
}
