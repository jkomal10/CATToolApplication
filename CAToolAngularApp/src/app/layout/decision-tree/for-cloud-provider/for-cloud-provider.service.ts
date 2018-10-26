import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {

  private evaluationOrder = 'http://localhost:8090/cloudProvider';
  // private cloudProviderRuleUrl = 'http://localhost:8090/cloudProvider/getAllCloudProviderQuestion';
  private getAllQuestions='http://localhost:8090/assessmentQuestions/getAllQuestions';

  constructor(private http:HttpClient) { }

  
    
CollectData(){
  const url = 'http://localhost:8090/cloudProvider/getAll';
  return this.http.get(url);
  }

  // private comptransfer = new BehaviorSubject("Hello");
  //       users = this.comptransfer.asObservable();

  // sendMsgtoOtherComponent(messsage)
  // {

  // }

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

  // CollectCloudableRuleQuestions(cloudproviderId : number){
  //   console.log(`${this.cloudProviderRuleUrl}/${cloudproviderId}`);
  //   return this.http.get(`${this.cloudProviderRuleUrl}/${cloudproviderId}`);
  // }


  CollectCloudableRuleQuestions(){
    // console.log(`${this.cloudProviderRuleUrl}/${cloudproviderId}`);
    return this.http.get(`${this.getAllQuestions}`);
  }


  // CollectCloudableRuleQuestions(cloudproviderId : number){
  //   return this.http.get(`${this.cloudProviderRuleUrl}/${cloudproviderId}`);

  // }


}
