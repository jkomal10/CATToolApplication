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
   baseUrl = 'http://localhost:8090/cloudableRule/save';
   CollectData(){
   //const url = 'http://localhost:8090/option/getAll';
   this.clientIdValue=this.myStorage.getCurrentUserObject().clientId;
   const url= 'http://localhost:8090/assessmentQuestions/getAllCloudableQuestions';
   return this.http.get(url+`/`+this.clientIdValue);
    }

    addClodableRule(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }

    collectRule()
    {
      const collectRulesUrl="http://localhost:8090/cloudableRule/getAll";
      return this.http.get(collectRulesUrl);
    }

    collectOptions()
    {
      const collectOptionsUrl = "http://localhost:8090/option/getAll";
      return this.http.get(collectOptionsUrl);
    }

    collectQuestion(clientId:number){
      const CollectQuestionUrl="http://localhost:8090/assessmentQuestions/getCloudableQuestion";
      return this.http.get(CollectQuestionUrl+`/`+clientId);
    }
}
