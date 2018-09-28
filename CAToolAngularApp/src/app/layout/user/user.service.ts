import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
providedIn: 'root'
})
export class UsersService {
     addUserURL:String ='http://localhost:8090/user/addUser';

constructor(private http:HttpClient) { }

CollectData(){
const url = 'http://localhost:8090/user/getAll';
return this.http.get(url);
}

addUser(users : Object):Observable<Object>{
    return this.http.post(`${this.addUserURL}`+`create`,users);
}
} 