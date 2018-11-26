import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../utility/service/localStorage.service';
// import 'rxjs/add/observable/merge';
// import 'rxjs/add/operator/map';

@Injectable({
providedIn: 'root'
})
export class UsersService {

  ipAddress : string;

  constructor(private http:HttpClient,private myStorage:LocalStorageService) { }


CollectData(clientName : string): Observable<Object>{
    return this.http.get(this.myStorage.getLocalhostURL()+`/user/getAll/`+clientName);
  }
  
getAllUsers(clientName : string): Observable<Object>{
  console.log(this.myStorage.getLocalhostURL()+`/user/getAll/`+this.myStorage.getClient());
  return this.http.get(this.myStorage.getLocalhostURL()+`/user/getAll/`+clientName);
  }

getUserByUserName(clientName:string,userName:string)
{
  const getuserByName = "http://localhost:8090/user/getUserId";
  return this.http.get(getuserByName+'/'+clientName+'/'+userName);
}

countNumberOfUsers()
{
  return this.http.get(this.myStorage.getLocalhostURL()+`/user/getUserCount`);
}
  
addUser(user: Object): Observable<Object> {
  return this.http.post(this.myStorage.getLocalhostURL()+`/user/addUser/create/`+this.myStorage.getCurrentUser(), user);
}

deactivate(userId: number)
{
  return this.http.put(this.myStorage.getLocalhostURL()+`/user/deactivateUser/`+userId,  { responseType: 'text' });
}

changePassword(userName: String,password: String,newPassword: String){
  console.log(this.myStorage.getLocalhostURL()+ `/user/changePassword/`+userName+`/`+password+`/`+newPassword);
  return this.http.get(this.myStorage.getLocalhostURL()+ `/user/changePassword/`+userName+`/`+password+`/`+newPassword);
}

private comptransfer = new BehaviorSubject("Hello");
        users = this.comptransfer.asObservable();

        sendUsertoOtherComponent(messsage){
         this.comptransfer.next(messsage);
        }
        
        sendMsgtoOtherComponent(messsage){
        this.comptransfer.next(messsage);
        } 

        sendIpAddresstoOtherComponent(messsage)
        {
          this.comptransfer.next(messsage);
        }

      updateUser(user: Object): Observable<Object> {
        return this.http.put(this.myStorage.getLocalhostURL()+ `/user/updateUser/update/`+this.myStorage.getCurrentUser(), user);
      }

      deleteUser(userId: number): Observable<any> {
        return this.http.delete(this.myStorage.getLocalhostURL()+`/user/deleteUserById/`+userId, { responseType: 'text' });
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