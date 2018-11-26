import { Injectable } from '@angular/core';
import { Observable } from '../../../../node_modules/rxjs';
import { HttpClient } from '../../../../node_modules/@angular/common/http';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  userName : String;
  clientNameValue : String;
  constructor(private http: HttpClient,private myStorage:LocalStorageService) { }
  private url="http://localhost:8090/feedback/save";

  addFeedback(feedback: Object): Observable<Object> {
    console.log("feedback for user");
    this.userName=this.myStorage.getCurrentUser();
    this.clientNameValue=this.myStorage.getClient();
    return this.http.post(`${this.url}`+`/`+this.userName+`/`+this.clientNameValue,feedback);
   }
}
