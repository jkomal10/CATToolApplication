import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http'; 


@Injectable({
  providedIn: 'root'
})
export class AddAssessmentQuestionService {

  private baseUrl = 'http://localhost:8090/assessmentQuestions/saveAssessmentQuestions';

  constructor(private http: HttpClient) {
    
   }

  createQuestion(question: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, question);
  }

}
