import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from '../../../../../node_modules/rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateQuestionService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8090/assessmentQuestions/updateQuestions/update/';

  updateCustomer(questionId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}`, value);
  }

}
