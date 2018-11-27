import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';


@Injectable({
  providedIn: 'root'
})
export class ForCloudableService {

  private collectRulesUrl="http://localhost:8090/cloudableRule/getAll";
  private CollectCloudableQuestionUrl="http://localhost:8090/assessmentQuestions/getCloudableQuestion";
  private baseUrl = 'http://localhost:8090/cloudableRule/save';
  private url= 'http://localhost:8090/assessmentQuestions/getAllCloudableQuestions';
  clientIdValue : number;
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

   
   CollectData(){
   this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
   return this.http.get(`${this.url}`+`/`+this.clientIdValue);
    }

   getCloudableQuestions(){
      this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
      return this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getCloudableQuestion/`+this.clientIdValue);
    }

    addClodableRule(cloudablerule: Object): Observable<Object> {
      return this.http.post(this.myStorage.getdomainURL() + `/cloudableRule/save/create`, cloudablerule);

    }

    collectRule(clientId:number)
    {
      return this.http.get(this.myStorage.getdomainURL()+`/cloudableRule/getAll/`+clientId);
    }

    collectOptions()
    {
      return this.http.get(this.myStorage.getdomainURL()+`/option/getAll`);
    }

    collectQuestion(clientId:number){
      return this.http.get(this.myStorage.getdomainURL()+`/assessmentQuestions/getCloudableQuestion/`+clientId);
    }
}
