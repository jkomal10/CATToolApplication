import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';


@Injectable({
  providedIn: 'root'
})
export class ForCloudableService {

  clientIdValue : number;
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

   getCloudableQuestions(){
      this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
      return this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getAllCloudableQuestions/`+this.clientIdValue);
    }

    addClodableRule(cloudablerule: Object): Observable<Object> {
      return this.http.post(this.myStorage.getdomainURL() + `/cloudableRule/save/create`, cloudablerule);
    }

    collectRule()
    {
      return this.http.get(this.myStorage.getdomainURL()+`/cloudableRule/getAll`);
    }

    collectOptions()
    {
      return this.http.get(this.myStorage.getdomainURL()+`/option/getAll`);
    }

    collectQuestion(clientId:number){
      return this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getCloudableQuestion/`+clientId);
    }
}
