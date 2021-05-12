import { Location } from '@angular/common';
import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/serivce/customer.service';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {
  //Checking variables
  loginStatus: any = {
    message: null,
    isLogin: null
  };
  //Data to send
  loginData: any = {
    userId: null,
    password: null
  }

  // Reference DOM by ViewChild
  @ViewChild('emp') emp!: ElementRef;
  @ViewChild('cus') cus!: ElementRef;

  public loginType = 'khách hàng';

  isSubmitted!: boolean;

  // tslint:disable-next-line:variable-name
  constructor(private _location: Location, private customerService: CustomerService, private router: Router) { }

  changeLoginType(type: string): void {
    this.loginType = type;
    // Change border after choosing login type
    if (type === 'khách hàng') {
      this.cus.nativeElement.style.border = '1px solid #0068bd';
      this.emp.nativeElement.style.border = 'none';
    }
    else {
      this.emp.nativeElement.style.border = '1px solid #0068bd';
      this.cus.nativeElement.style.border = 'none';
    }
  }

  onSubmit(form: NgForm): void {
    console.log(form);
    // Check input is submitted or not
    this.isSubmitted = true;
    if (form.valid) {
      this.loginData.userId = form.value.userId;
      this.loginData.password = form.value.password;
      this.customerService.login(this.loginData).subscribe(
        result => {
          let res: any = result;
          console.log(res);
          if (res !== null) {
            //Check login type
            if (this.loginType === 'khách hàng' && res.type === 1) {
              //Customer
              this.router.navigate(['/']);
            }
            else if (this.loginType === 'nhân viên' && res.type === 2) {
              //Admin
              this.router.navigate(['/management']);
            }
            else {
              this.loginStatus.message = 'Sai tài khoản hoặc mật khẩu';
              this.loginStatus.isLogin = false;
              localStorage.removeItem('loginStatus');
            }
          }
          else {
            //Set login status
            this.loginStatus.message = 'Sai tài khoản hoặc mật khẩu';
            this.loginStatus.isLogin = false;
            localStorage.removeItem('loginStatus');
          }
        },
        error => {
          console.error("Server error !!!");
          //Set login status
          this.loginStatus.message = 'Server error';
          this.loginStatus.isLogin = false;
          localStorage.removeItem('loginStatus');
        }
      );
    }
  }

  backClicked(): void {
    // Return previous page
    this._location.back();
  }

  ngOnInit(): void {
  }

  // Setting login type is "Cus" after create template
  ngAfterViewInit(): void {
    this.cus.nativeElement.style.border = '1px solid #0068bd';
  }

}
