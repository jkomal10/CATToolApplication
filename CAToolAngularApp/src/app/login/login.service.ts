import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, BehaviorSubject} from 'rxjs';


import {IUser} from './user';
import { Users } from '../layout/user/Users';

@Injectable()
export class LoginService{
    users: Users = new Users();
    private getUserByID_url: string = "http://localhost:8090/user/getById";

    constructor(private http: HttpClient) {
       
     }

    getUserByUserNamePassword(username : string,password : string):Observable<any>{
        console.log(`${this.getUserByID_url}/${username}/${password}`)
        return this.http.get<IUser>(`${this.getUserByID_url}/${username}/${password}`);  
    }

    private  comptransfer  =  new  BehaviorSubject("Hello");
    question  =  this.comptransfer.asObservable();

    sendMsgtoOtherComponent(messsage) {
        this.comptransfer.next(messsage);
    }
}