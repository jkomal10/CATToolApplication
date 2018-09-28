import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';


import {IUser} from './user';

@Injectable()
export class LoginService{
    private getUserByID_url: string = "http://localhost:8090/user/getById";

    constructor(private http: HttpClient) {
       
     }

    getUserByUserNamePassword(username : string,password : string):Observable<any>{
        console.log(`${this.getUserByID_url}/${username}/${password}`)
        return this.http.get<IUser>(`${this.getUserByID_url}/${username}/${password}`);  
    }
}