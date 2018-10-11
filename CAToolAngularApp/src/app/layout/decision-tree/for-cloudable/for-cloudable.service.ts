import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ForCloudableService {

  constructor(private http:HttpClient) { }
 // url = 'http://localhost:8090/option/getAll';
   CollectData(){
   const url = 'http://localhost:8090/option/getAll';
   return this.http.get(url);
    }

  //   CollectData()  : Observable<any> {
  //     return this.http.get(this.url)
  //         .map(this.extractData)
  //         .catch(this.handleErrorObservable);
  // }

  // private extractData(res: Response) {
  //     let body = res.json();
  //     return body;
  // }

  // private handleErrorObservable (error: Response | any) {
  //     console.error(error.message || error);
  //     return Observable.throw(error.message || error);
  // }
}
