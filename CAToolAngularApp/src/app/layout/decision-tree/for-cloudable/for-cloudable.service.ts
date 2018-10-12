import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ForCloudableService {

  constructor(private http:HttpClient) { }
   baseUrl = 'http://localhost:8090/cloudableRule/save';
   CollectData(){
   const url = 'http://localhost:8090/option/getAll';
   return this.http.get(url);
    }

    addClodableRule(cloudablerule: Object): Observable<Object> {
      console.log(`${this.baseUrl }/create`);
      return this.http.post(`${this.baseUrl }` + `/create`, cloudablerule);
    }
}
