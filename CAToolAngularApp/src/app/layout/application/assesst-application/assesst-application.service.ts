import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssesstApplicationService {

  constructor(private http:HttpClient) { }
  baseUrl ='http://localhost:8090/answer/save';
  AllRuleUrl='http://localhost:8090/application/AllRuleCheck';
  UpdateAnswersUrl='http://localhost:8090/answer/getAnswersByApplicationId/7';

  CollecOptiontData(clientId : number){
    // const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';getAllQuestions
    const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return this.http.get(url+`/`+clientId);
     }

     saveAssessApplication(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      console.log(JSON.stringify(cloudablerule));
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }

    UpdateAnswers(applicationId:number): Observable<any>{
    return this.http.get(`${this.UpdateAnswersUrl}`);
    }

    saveAssessApplicationUpdate(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.put(`${this.baseUrl }` + `/create`, cloudablerule);
    }

    AllRuleCheck(applicationId:number): Observable<any>{
      console.log(`${this.AllRuleUrl}`+`/`+applicationId);
      return this.http.get(`${this.AllRuleUrl}`+`/`+applicationId);
    }
}
