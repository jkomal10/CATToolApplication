import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PublicPassService {

  constructor(private http: HttpClient) { }

  CollectData() {
    console.log('**************public pass service************');
    const  url='http://localhost:8090/migrationRule/getAllQuestionsForMigration';
    return  this.http.get(url);
  }
}
