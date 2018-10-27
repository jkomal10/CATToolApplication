import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssesstApplicationService {

  constructor(private http:HttpClient) { }
  baseUrl ='http://localhost:8090/answer/save';
  UpdateAnswersUrl='http://localhost:8090/answer/getAnswersByApplicationId/7';
  CollecOptiontData(){
    const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return this.http.get(url);
     }

     saveAssessApplication(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }

    UpdateAnswers(applicationId:number): Observable<any>{
    return this.http.get(`${this.UpdateAnswersUrl}`);
    }

    saveAssessApplicationUpdate(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.put(`${this.baseUrl }` + `/create`, cloudablerule);
    }
}
