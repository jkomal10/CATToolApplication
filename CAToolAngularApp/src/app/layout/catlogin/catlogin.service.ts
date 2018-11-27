import { Injectable } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Users } from './Users';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatloginService {

  constructor(private http: HttpClient) {
     
  }

  ngOnInit() {
  }

  users: Users = new Users();
  private getUserByID_url: string = "http://localhost:8090/user/getById";


  getUserByUserNamePassword(username : string,password : string):Observable<any>{
      console.log(`${this.getUserByID_url}/${username}/${password}`)
      return this.http.get(`${this.getUserByID_url}/${username}/${password}`);  
  }


  getClientByClientId(clientId:number):Observable<any>{
    return this.http.get(`http://localhost:8090/user/get/client/`+clientId);
  }

  private  comptransfer  =  new  BehaviorSubject("Hello");
  question  =  this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage) {
      this.comptransfer.next(messsage);
  }
}
