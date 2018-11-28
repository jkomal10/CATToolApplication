import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { currentUser } from '../model/currentUser.model';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {
  
  user: currentUser = new currentUser();

  constructor(private http:HttpClient) { }

  setLoggedInTrue(isLoggedin : string){
    localStorage.setItem('isLoggedin',isLoggedin);
  }

  setdomainURL(){
    localStorage.setItem('local','http://localhost:8090');
  }

  setClientName(clientName:string){
    localStorage.setItem('clientName',clientName);
  }

  getClientName(){
    return localStorage.getItem('clientName');
  }

  getdomainURL(){
    return localStorage.getItem('local');
  }

  setCurrentUserObject(user : Object){
    localStorage.setItem('user',JSON.stringify(user));
  }

  getCurrentUserObject() : currentUser{
    return JSON.parse(localStorage.getItem('user'));
  }
  
  setIpAddress(ip : string){
    localStorage.setItem('ip',ip);
  }
  setComponent(componentName: string){
    localStorage.setItem('component', componentName); 
  }

  getIpAddress(){
    return localStorage.getItem('ip');
  } 

  getLoggedInTrue(){
    return localStorage.getItem('isLoggedin');
  }

  clearLoggedIn(){
    return localStorage.removeItem('isLoggedin');
  }

  clearCurrentUser(){
    return localStorage.removeItem('user');
  }



}
