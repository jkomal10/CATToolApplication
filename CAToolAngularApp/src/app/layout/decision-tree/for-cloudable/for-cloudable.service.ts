import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';


@Injectable({
  providedIn: 'root'
})
export class ForCloudableService {

  clientNameValue : String;
  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }
   baseUrl = 'http://localhost:8090/cloudableRule/save';
   CollectData(){
   //const url = 'http://localhost:8090/option/getAll';
   this.clientNameValue=this.myStorage.getClient();
   const url= 'http://localhost:8090/assessmentQuestions/getAllCloudableQuestions';
   return this.http.get(url+`/`+this.clientNameValue);
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

    collectQuestion(){
      const CollectQuestionUrl="http://localhost:8090/assessmentQuestions/getAllQuestions";
      return this.http.get(CollectQuestionUrl);
    }
}
