import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
providedIn: 'root'
})
export class UsersService {

constructor(private http:HttpClient) { }

CollectData(){
const url = 'http://localhost:8090/users/getAllUsers';
return this.http.get(url);
}
} 