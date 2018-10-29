import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
// import 'rxjs/add/observable/merge';
// import 'rxjs/add/operator/map';

@Injectable({
providedIn: 'root'
})
export class UsersService {
  ipAddress : string;
  
   private addUserURL ='http://localhost:8090/user/addUser';
   private addUrl = 'http://localhost:8090/user/addUser';
   private updateUrl = 'http://localhost:8090/user/updateUser';
   private deleteUrl = 'http://localhost:8090/user/deleteUserById';
   private changePasswordUrl = 'http://localhost:8090/user/changePassword';
constructor(private http:HttpClient) { }

CollectData(){
const url = 'http://localhost:8090/user/getAll';

return this.http.get(url);
}

newAddURL: string = 'http://localhost:8090/user/addUser';
  
addUser(application: Object): Observable<Object> {
  
  return this.http.post(`${this.newAddURL}` + `/create/`+localStorage.getItem('userName'), application);
}

changePassword(userName: String,password: String,newPassword: String){
  console.log(`${this.changePasswordUrl}`+ `/`+userName+`/`+password+`/`+newPassword);
  return this.http.get(`${this.changePasswordUrl}`+ `/`+userName+`/`+password+`/`+newPassword);
}

private comptransfer = new BehaviorSubject("Hello");
        users = this.comptransfer.asObservable();
        
        sendMsgtoOtherComponent(messsage){
        this.comptransfer.next(messsage);
        } 

        sendIpAddresstoOtherComponent(messsage)
        {
          this.comptransfer.next(messsage);
        }

      updateUser(user: Object): Observable<Object> {
        return this.http.put(`${this.updateUrl}`+ `/update/`+localStorage.getItem('userName'), user);
      }

      deleteUser(userId: number): Observable<any> {
        return this.http.delete(`${this.deleteUrl}/${userId}`, { responseType: 'text' });
      }

      getIpAddress() : Observable<any>{
        // const headers = new HttpHeaders({ 'Content-Type': 'application/json' ,'Origin' : 'http://localhost:3000', "Access-Control-Allow-Origin" : "*" });
       const headers = new HttpHeaders({ "Access-Control-Allow-Origin" : "*" });
        return this.http.get('http://ipinfo.io');
    }

    private handleError(error: HttpErrorResponse):
      Observable<any> {
        //Log error in the browser console
        console.error('observable error: ', error);
        return Observable.throw(error);
      }

} 