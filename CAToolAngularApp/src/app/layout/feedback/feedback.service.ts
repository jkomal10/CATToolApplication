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

  addFeedback(feedback: Object): Observable<Object> {
    this.userName=this.myStorage.getCurrentUserObject().userName;
    this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
    return this.http.post(this.myStorage.getdomainURL()+`/feedback/save/`+this.userName+`/`+this.clientIdValue,feedback);
   }
}
