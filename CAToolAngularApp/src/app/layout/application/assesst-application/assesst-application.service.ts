import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AssesstApplicationService {

  constructor(private http:HttpClient) { }

  CollecOptiontData(){
    const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
    return this.http.get(url);
     }
}
