import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor(private http:HttpClient) { }

  setCurrentUser(currentUser : string){
    localStorage.setItem('userName' , currentUser);
  }

  setIsAdmin(trueFalseValue : string){
    localStorage.setItem('isUserActive',trueFalseValue);        
  }

  setClient(clientName : string){
    localStorage.setItem('clientName',clientName);
  }

  setFirstNameOfCurrentUser(currentUserfirstName : string){
    localStorage.setItem('firstName',currentUserfirstName);
  }

  setLastNameOfCurrentUser(currentUserlastName : string){
    localStorage.setItem('lastName',currentUserlastName);
  }

  getCurrentUser(){
    return localStorage.getItem('userName');
  }

  getIsAdmin(){
    return localStorage.getItem('isUserActive');        
  }

  getClient(){
    return localStorage.getItem('clientName');
  }

  getFirstNameOfCurrentUser(){
    return localStorage.getItem('firstName');
  }

  getLastNameOfCurrentUser(){
    return localStorage.getItem('lastName');
  }

}
