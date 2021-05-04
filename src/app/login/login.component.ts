import { Location } from '@angular/common';
import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {
  // Reference DOM by ViewChild
  @ViewChild('emp') emp!: ElementRef;
  @ViewChild('cus') cus!: ElementRef;

  public loginType = 'khách hàng';

  isSubmitted!: boolean;

  // tslint:disable-next-line:variable-name
  constructor(private _location: Location) { }

  changeLoginType(type: string): void{
    this.loginType = type;
    // Change border after choosing login type
    if (type === 'khách hàng'){
      this.cus.nativeElement.style.border = '1px solid #0068bd';
      this.emp.nativeElement.style.border = 'none';
    }
    else{
      this.emp.nativeElement.style.border = '1px solid #0068bd';
      this.cus.nativeElement.style.border = 'none';
    }
  }

  onSubmit(form: NgForm): void{
    console.log(form);
    // Check input is submitted or not
    this.isSubmitted = true;
  }

  backClicked(): void{
    // Return previous page
    this._location.back();
  }

  ngOnInit(): void {
  }

  // Setting login type is "Cus" after create template
  ngAfterViewInit(): void{
    this.cus.nativeElement.style.border = '1px solid #0068bd';
  }

}
