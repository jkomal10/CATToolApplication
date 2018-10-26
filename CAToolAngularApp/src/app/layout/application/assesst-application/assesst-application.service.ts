import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssesstApplicationService {

  constructor(private http:HttpClient) { }
  baseUrl ='http://localhost:8090/answer/save';
  CollecOptiontData(){
    const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return this.http.get(url);
     }

     saveAssessApplication(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }
}
