import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForCloudProviderService {

  constructor(private http:HttpClient) { }

  
    
CollectData(){
  const url = 'http://localhost:8090/cloudProvider/getAll';
  
  return this.http.get(url);
  
  }
}
