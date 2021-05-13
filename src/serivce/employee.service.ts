import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const defaultAccountUrl = "http://localhost:8080/api/accountinfo";
const defaultCusAccountUrl = "http://localhost:8080/api/empinfo";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {

  }

  registerLoginData(refisterData: any): Observable<any> {
    return this.http.post(defaultAccountUrl + "/createAccountInfo", refisterData);
  }

  registerPersonalData(refisterData: any): Observable<any> {
    return this.http.post(defaultCusAccountUrl + "/createEmpInfo", refisterData);
  }

  getAllEmployee(page: number, size: number): Observable<any>{
    return this.http.get<any>(defaultCusAccountUrl + "/getAllEmpInfo/?page=" + page +"&size=" + size);
  }
}
