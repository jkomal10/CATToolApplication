import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRoleService {

  constructor(private http:HttpClient) { }

  getApplicationByUserName(userName:string){
    return this.http.get(`http://localhost:8090/application/getApplicationByUserName`+`/`+userName);
  }

  private comptransfer = new BehaviorSubject("User Role");
    question = this.comptransfer.asObservable();
  
    sendMsgtoOtherComponent(messsage){
        this.comptransfer.next(messsage);
    }

}
