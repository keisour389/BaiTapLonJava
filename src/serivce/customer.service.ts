import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const defaultAccountUrl = "http://localhost:8080/api/accountinfo";
const defaultCusAccountUrl = "http://localhost:8080/api/cusinfo";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  login(loginData: any): Observable<any> {
    return this.http.post(defaultAccountUrl + "/loginAccountInfo", loginData);
  }

  registerLoginData(refisterData: any): Observable<any> {
    return this.http.post(defaultAccountUrl + "/createAccountInfo", refisterData);
  }
  registerPersonalData(refisterData: any): Observable<any> {
    return this.http.post(defaultCusAccountUrl + "/createCusInfo", refisterData);
  } 
}
