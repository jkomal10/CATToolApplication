import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from '../Application';
import { Observable } from 'rxjs';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class ViewApplicationService {

  constructor(private http:HttpClient, private myStorage:LocalStorageService) { }
  CollectSingleApplicationData(applicationId: number): Observable<any>{
    return this.http.get(this.myStorage.getdomainURL()+`/application/getApplicationById`+applicationId, { responseType: 'text' });
    
  }
}
