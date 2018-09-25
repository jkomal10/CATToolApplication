import { Component, Input } from '@angular/core';
import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IUser} from './user';
import { HttpHeaders } from '@angular/common/http';

  const httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':  'application/json',
    
   })
};

@Injectable()
export class AddAssessmentQuestionsService {

    private getUserByID_url: string = "http://localhost:8090/user/findByusername/";
    private postURL: string = "http://localhost:8090/assessmentQuestions/saveAssessmentQuestions";

    constructor(private http: HttpClient) {

        
       
    }


    save (user: IUser): Observable<IUser> {
      return this.http.post<IUser>(this.postURL, user, httpOptions);
 }
    
    
    // save (user : IUser): Observable<IUser> {
    //     console.log('***************************postmethod****************************');
    //     console.log(JSON.stringify(user));
    //     let headers = new HttpHeaders();
    //     headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    //     return this.http.post<IUser>(this.postURL, JSON.stringify(user), {headers:headers});
    //   }

    //   AddEmployee(newData : any){
    //     console.log(newData);
    //     let headers = new HttpHeaders();
    //     headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    //     return this.http.post(this.AddEmployee_url,JSON.stringify(newData),{headers: headers});
    // } 
    // save(user : IUser):Observable<any>{
    //    // console.log(user+"****");
    //     let headers = new HttpHeaders();
    //    // headers.append("Authorization", "Basic ");
    //     headers.append('Content-Type', 'application/json; charset=utf-8');
    //     return this.http.post<any>('http://localhost:8090/assessmentQuestions/saveAssessmentQuestions',user,{headers:headers});
    // }

    CollectData(){
        const url = 'http://localhost:8090/assessmentQuestions/getAllQuestions';
        return this.http.get(url);
        }


        // save(user : IUser):Observable<IUser>{
        //     return this.http.post<IUser>('http://localhost:8090/assessmentQuestions/saveAssessmentQuestions',user,{
        //         headers: new HttpHeaders({
        //             'content-type' : 'application/json'
        //         })
        //     }).pipe();
        // }
        // post(url: string, body: any | null, options?:{
        //     headers?:HttpHeaders|{
        //         [header:string]:string|string[];
        //     };
        // })
    
    
}
