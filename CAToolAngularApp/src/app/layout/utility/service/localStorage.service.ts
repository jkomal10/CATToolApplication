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

  getIsUserActive(){
    return localStorage.getItem('isUserActive');
  }

  getLoggedInTrue(){
    return localStorage.getItem('isLoggedin');
  }

  getCurrentUser(){
    return this.user.userName;
  }

  getIsAdmin(){
    return this.user.isAdmin;       
  }

  getClient(){
    return this.user.clientName;
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
