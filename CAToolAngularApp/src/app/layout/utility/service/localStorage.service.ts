import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { currentUser } from './currentUser.model';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {
  user: currentUser = new currentUser();

  constructor(private http:HttpClient) { }

  setLoggedInTrue(isLoggedin : string){
    localStorage.setItem('isLoggedin',isLoggedin);
  }

  setIsUserActive(isUserActive : string){
    localStorage.setItem('isUserActive',isUserActive);
  }

  setLocalhostURL(){
    localStorage.setItem('local','http://localhost:8090');
  }

  getLocalhostURL(){
    return localStorage.getItem('local');
  }

  setCurrentUserObject(user : Object){
    localStorage.setItem('user',JSON.stringify(user));
    this.user=JSON.parse(localStorage.getItem('user'));
    localStorage.setItem('userName',this.user.userName);
    localStorage.setItem('clientName',this.user.clientName);
    localStorage.setItem('firstName',this.user.firstName);
    localStorage.setItem('lastName',this.user.lastName);
  }

  setIpAddress(ip : string){
    localStorage.setItem('ip',ip);
  }

  getIpAddress(){
    return localStorage.getItem('ip');
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
    this.user=JSON.parse(localStorage.getItem('user'));
    return localStorage.getItem('firstName');
  }

  getLastNameOfCurrentUser(){
    this.user=JSON.parse(localStorage.getItem('user'));
    return localStorage.getItem('lastName');
  }

  clearLoggedIn(){
    return localStorage.removeItem('isLoggedin');
  }

  clearCurrentUser(){
    return localStorage.removeItem('user');
  }

}
