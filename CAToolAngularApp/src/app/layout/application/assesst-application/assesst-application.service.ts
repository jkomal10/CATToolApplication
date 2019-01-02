import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class AssesstApplicationService {

  constructor(private http: HttpClient) { }
  baseUrl  = 'http://localhost:8090/answer/save';
  AllRuleUrl = 'http://localhost:8090/application/AllRuleCheck';
  UpdateAnswersUrl = 'http://localhost:8090/answer/getAnswersByApplicationId';
 
  updateUrl='http://localhost:8090/answer/update';
  CollecOptiontData(clientId: number) {
    const  url  =  'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return  this.http.get(url + `/` + clientId);
  }

  saveAssessApplication(cloudablerule: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
  }
  Update(answer:any):Observable<any>{
    return this.http.put(`${this.updateUrl}`,answer);
  } 
    
  getAnswers(applicationId: number): Observable<Object> {
    console.log(this.http.get(`${this.UpdateAnswersUrl}` + `/` + applicationId));
    return  this.http.get(`${this.UpdateAnswersUrl}` + `/` + applicationId);
  }

  saveAssessApplicationUpdate(cloudablerule: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl }` + `/create`, cloudablerule);
  }

  AllRuleCheck(applicationId: number): Observable<any> {
    return this.http.get(`${this.AllRuleUrl}` + `/` + applicationId);
  }
}
