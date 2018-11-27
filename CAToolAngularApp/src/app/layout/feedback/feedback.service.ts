import { Injectable } from '@angular/core';
import { Observable } from '../../../../node_modules/rxjs';
import { HttpClient } from '../../../../node_modules/@angular/common/http';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  userName : String;
  clientIdValue : number;
  constructor(private http: HttpClient,private myStorage:LocalStorageService) { }
  private url="http://localhost:8090/feedback/save";

  addFeedback(feedback: Object): Observable<Object> {
    console.log("feedback for user");
    this.userName=this.myStorage.getCurrentUserObject().userName;
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.post(`${this.url}`+`/`+this.userName+`/`+this.clientIdValue,feedback);
   }
}
