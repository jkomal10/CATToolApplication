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

     addClodableRule(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }

    collectRule(clientId:number)
    {
     
      return this.http.get(`${this.collectRulesUrl}`+`/`+clientId);
    }

    collectOptions()
    {
      const collectOptionsUrl = "http://localhost:8090/option/getAll";
      return this.http.get(collectOptionsUrl);
    }

    collectQuestion(clientId:number){
     
      return this.http.get(`${this.CollectCloudableQuestionUrl}`+`/`+clientId);
    }
}
