import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { Login } from './login.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginStatus = new BehaviorSubject<Login>(null!);

  constructor(private router: Router) { }

  //This method set in app component to auto login after loading page
  autoLogin(): void {
    const loginStatus: {
      userId: string,
      _expirationDate: string //Get string parse to date
    } = JSON.parse(localStorage.getItem('loginStatus')!);
    //Check null
    if (!loginStatus) {
      return;
    }
    else if (loginStatus.userId) {
      //User valid after logging in
      //Parse expiry date form string to date
      const currentLoginStatus = new Login(loginStatus.userId, new Date())
      this.loginStatus.next(currentLoginStatus);
      //Auto log out
      //Expiry data minus now time
      // const timeOut = new Date(user._tokenExpirationDate).getTime() - new Date().getTime();
      // this.autoLogout(timeOut);
      // console.log(timeOut);
    }
  }

  logout(): void {
    //Set subject return to null
    this.loginStatus.next(null!);
    //Clear data storage afer log out
    localStorage.removeItem('loginStatus');
    this.router.navigate(['/login']);
    //Clear time out if loggin out manually
    // if(this.tokenExpirationTimer){
    //     clearTimeout(this.tokenExpirationTimer);
    // }
    // this.tokenExpirationTimer = null;
}

  handleAuthentication(userId: string, _expirationDate: number): void {
    const newExpirationDate = new Date(_expirationDate + 3600);
    const loginStatus = new Login(userId, newExpirationDate);
    this.loginStatus.next(loginStatus);
    localStorage.setItem('loginStatus', JSON.stringify(loginStatus));
    console.log(this.loginStatus);
  }
}
