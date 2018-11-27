import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class HelpService {

  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

  saveIssue(text:object)
  {
    return this.http.post(this.myStorage.getdomainURL()+`/reportIssue/issue`,text);
  }

}
