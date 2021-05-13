import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLogin!: boolean;
  loginStatus!: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.checkIsLogin();
  }

  checkIsLogin(){
    if(JSON.parse(localStorage.getItem('loginStatus')!) !== null){
      this.isLogin = true;
      this.loginStatus = JSON.parse(localStorage.getItem('loginStatus')!);
    }
    else{
      this.isLogin = false;
      console.error("Login status info is null");
    }
  }

  logout(): void{
    localStorage.removeItem('loginStatus');
    document.location.reload();
  }

}
