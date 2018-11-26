import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
providedIn: 'root'
})
export class UsersService {

ipAddress : string;
constructor(private http:HttpClient,private myStorage:LocalStorageService) { }

getAllUsers(clientName : string): Observable<Object>{
  return this.http.get(this.myStorage.getdomainURL()+`/user/getAll/`+clientName);
  }

getUserByUserName(clientName:string,userName:string)
{
  return this.http.get(this.myStorage.getdomainURL()+'/user/getUserId/'+clientName+'/'+userName);
}

countNumberOfUsers()
{
  return this.http.get(this.myStorage.getdomainURL()+`/user/getUserCount`);
}
  
addUser(user: Object): Observable<Object> {
  return this.http.post(this.myStorage.getdomainURL()+`/user/addUser/create/`+this.myStorage.getCurrentUserObject().userName, user);
}

deactivate(userId: number)
{
  return this.http.put(this.myStorage.getdomainURL()+`/user/deactivateUser/`+userId,  { responseType: 'text' });
}

changePassword(userName: String,password: String,newPassword: String){
  console.log(this.myStorage.getdomainURL()+ `/user/changePassword/`+userName+`/`+password+`/`+newPassword);
  return this.http.get(this.myStorage.getdomainURL()+ `/user/changePassword/`+userName+`/`+password+`/`+newPassword);
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
        return this.http.put(this.myStorage.getdomainURL()+ `/user/updateUser/update/`+this.myStorage.getCurrentUserObject().userName, user);
      }

      deleteUser(userId: number): Observable<any> {
        return this.http.delete(this.myStorage.getdomainURL()+`/user/deleteUserById/`+userId, { responseType: 'text' });
      }

      getIpAddress() : Observable<any>{
        const headers = new HttpHeaders({ "Access-Control-Allow-Origin" : "*" });
        return this.http.get('http://ipinfo.io');
    }

    private handleError(error: HttpErrorResponse):
      Observable<any> {
        console.error('observable error: ', error);
        return Observable.throw(error);
      }

} 