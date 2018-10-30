import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  CollectData(){
    const reassessUrl = 'http://localhost:8090/application/getAllReassessment';
    return this.http.get(reassessUrl);
    }

  
}
