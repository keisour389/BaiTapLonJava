import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const defaultAccountUrl = "http://localhost:8080/api/accountinfo";
const defaultEmpAccountUrl = "http://localhost:8080/api/empinfo";

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
    return this.http.post(defaultEmpAccountUrl + "/createEmpInfo", refisterData);
  }

  updatePersonalDate(updateData: any): Observable<any> {
    return this.http.put(defaultEmpAccountUrl + "/updateEmpInfo/", updateData);
  }

  getAllEmployee(page: number, size: number): Observable<any>{
    return this.http.get<any>(defaultEmpAccountUrl + "/getAllEmpInfo/?page=" + page +"&size=" + size);
  }
}
