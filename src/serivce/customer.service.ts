import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const defaultUrl = "http://localhost:8080/api/accountinfo";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  login(loginData: any): Observable<any> {
    return this.http.post(defaultUrl + "/loginAccountInfo/", loginData);
  }
}
