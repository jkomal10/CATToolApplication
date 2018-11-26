import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { currentUser } from './currentUser.model';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {
  user: currentUser = new currentUser();
  private localurl ='http://localhost:8090/user/getAll';
  constructor(private http:HttpClient) { }

  setCurrentUserObject(user : Object){
    localStorage.setItem('user',JSON.stringify(user));
    this.user=JSON.parse(localStorage.getItem('user'));
  }

  setLoggedInTrue(isLoggedin : string){
    localStorage.setItem('isLoggedin',isLoggedin);
  }

  setIsUserActive(isUserActive : string){
    localStorage.setItem('isUserActive',isUserActive);
  }

  setUsername(userName:string){
    localStorage.setItem('userName',userName);
  }

  setClient(client:string){
    localStorage.setItem('clientName',client);
  }

  getLocalhostURL(){
    localStorage.setItem('local','http://localhost:8090');
    return localStorage.getItem('local');
  }

  getIsUserActive(){
    return localStorage.getItem('isUserActive');
  }

  getLoggedInTrue(){
    return localStorage.getItem('isLoggedin');
  }

  getCurrentUser(){
    return localStorage.getItem('userName');
  }

  getIsAdmin(){
    return this.user.isAdmin;       
  }

  getClient(){
    return localStorage.getItem('clientName');
  }

  getFirstNameOfCurrentUser(){
    return this.user.firstName;
  }

  getLastNameOfCurrentUser(){
    return this.user.lastName;
  }

  clearLoggedIn(){
    return localStorage.removeItem('isLoggedin');
  }

  clearCurrentUser(){
    return localStorage.removeItem('user');
  }

}
