import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AuthService } from 'src/app/login/auth.service';

const defaultAccountUrl = "http://localhost:8080/api/accountinfo";
const defaultCusAccountUrl = "http://localhost:8080/api/cusinfo";
const defaultFeedbackurl = "http://localhost:8080/api/feedback"

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  login(loginData: any): Observable<any> {
    return this.http.post(defaultAccountUrl + "/loginAccountInfo/", loginData).pipe(
      tap(responseData => this.authService.handleAuthentication(loginData.userId!, new Date().getTime()))
    );
  }

  registerLoginData(refisterData: any): Observable<any> {
    return this.http.post(defaultAccountUrl + "/createAccountInfo", refisterData);
  }
  registerPersonalData(refisterData: any): Observable<any> {
    return this.http.post(defaultCusAccountUrl + "/createCusInfo", refisterData);
  }

  getCustomerInfoByUserId(userId: string): Observable<any> {
    return this.http.get<any>(defaultCusAccountUrl + "/getCusInfo/?id=" + userId);
  }
  
  sendFeedback(feedbackData: any): Observable<any> {
    return this.http.post(defaultFeedbackurl + "/createFeedback", feedbackData);
  }
}
