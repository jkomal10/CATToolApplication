import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRoleService {

  constructor(private http:HttpClient) { }

  getApplicationByUserName(userName:string){
      console.log(`http://localhost:8090/application/getApplicationByUserName`+`/`+userName);
      const url = 'http://localhost:8090/application/getApplicationByUserName';
      return this.http.get(`http://localhost:8090/application/getApplicationByUserName`+`/`+userName);
  }

}
