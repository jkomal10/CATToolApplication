import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HelpService {

  constructor(private http:HttpClient) { }

  private url="http://localhost:8090/reportIssue/issue";

  saveIssue(text:object)
  {
    // return this.http.post(`${this.newAddURL}` + `/create/`+localStorage.getItem('userName'), application);
    return this.http.post(`${this.url}`,text);
  }

}
