import { Injectable } from '@angular/core';
import { Observable } from '../../../../node_modules/rxjs';
import { HttpClient } from '../../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  userName : String;
  clientNameValue : String;
  constructor(private http: HttpClient) { }
  private url="http://localhost:8090/feedback/save";

  addFeedback(feedback: Object): Observable<Object> {
    console.log("feedback for user");
    this.userName=localStorage.getItem('userName');
    this.clientNameValue=localStorage.getItem('clientName');
    return this.http.post(`${this.url}`+`/`+this.userName+`/`+this.clientNameValue,feedback);
   }
}
