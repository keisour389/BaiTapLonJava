import { Location } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  isConfirmPasswordCorrectly!: boolean;
  userPassword: any = {
     password: null,
     confirmPassword: null
  }

  isAcceptTerm = false;

  // tslint:disable-next-line:variable-name
  constructor(private _location: Location) { }

  backClicked(): void{
    // Return previous page
    this._location.back();
  }

  onSubmit(form: NgModel): void{
    console.log(form);
    this.isConfirmPasswordCorrectly = this.checkConfirmPassword();
  }

  checkConfirmPassword(): boolean{
    if(this.userPassword.password === this.userPassword.confirmPassword){
      return true;
    }
    return false;
  }

  ngOnInit(): void {
  }

}
