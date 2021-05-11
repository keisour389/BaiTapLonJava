import { Location } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { CustomerService } from 'src/serivce/customer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  //Data to send
  loginData: any = {
    userId: null,
    password: null,
    type: null,
    status: null,
    createdOn: null,
    updatedOn: null,
    note: null
  }

  personalData: any = {
    userId: null,
    firstName: null,
    lastName: null,
    displayName: null,
    phoneNumber: null,
    birthday: null,
    gender: 'Nam',
    createdOn: null,
    updatedOn: null,
    note: null,
    username: null
  }

  isConfirmPasswordCorrectly!: boolean;
  userPassword: any = {
    password: null,
    confirmPassword: null
  }

  isAcceptTerm = false;

  // tslint:disable-next-line:variable-name
  constructor(private _location: Location, private customerService: CustomerService) { }

  backClicked(): void {
    // Return previous page
    this._location.back();
  }

  onSubmit(form: NgForm): void {
    console.log(form);
    this.isConfirmPasswordCorrectly = this.checkConfirmPassword();
    if (form.valid && this.isConfirmPasswordCorrectly) {
      //Binding login data
      this.bindingLoginData(form);
      console.log(this.loginData);
      //Binding personal data
      this.bindingPersonnalData(form);
      console.log(this.personalData);
      this.registerLoginData();
    }
  }

  registerLoginData(): void {
    this.customerService.registerLoginData(this.loginData).subscribe(
      result => {
        let res: any = result;
        if (res !== null) {
          console.log("Register login data successfully");
          //Continue register personal information
          this.customerService.registerPersonalData(this.personalData).subscribe(
            result => {
              let res: any = result;
              if (res !== null) {
                console.log("Register personal data successfully");
              }
              else{
                console.log("Register personal data failed");
              }
            },
            error => {
              console.error("Server occur error when registering personal data !!!");
            }
          )
        }
        else {
          console.log("Register failed");
        }
      },
      error => {
        console.error("Server occur error when registering login data !!!");
      }
    );
  }

  registerPersonalData(): void {
    this.customerService.registerPersonalData(this.personalData)
  }
  checkConfirmPassword(): boolean {
    if (this.userPassword.password === this.userPassword.confirmPassword) {
      return true;
    }
    return false;
  }

  private bindingLoginData(form: NgForm): void {
    this.loginData.userId = form.value.userId;
    this.loginData.password = form.value.password;
    this.loginData.type = 1; //Customers always have type is 1
    this.loginData.status = 1; //1 is default status. Normal status
    this.loginData.createdOn = this.createJsonNowDate();
    this.loginData.updatedOn = null;
    this.loginData.note = form.value.note;
  }

  private bindingPersonnalData(form: NgForm): void {
    this.personalData.userId = form.value.userId;
      this.personalData.firstName = form.value.firstName;
      this.personalData.lastName = form.value.lastName;
      this.personalData.displayName = this.personalData.firstName + " " + this.personalData.lastName;
      this.personalData.phoneNumber = form.value.phoneNumber;
      this.personalData.birthday = this.parseNormalDateToJsonDate(form.value.dob);
      this.personalData.gender = form.value.gender;
      this.personalData.createdOn = this.createJsonNowDate();
      this.personalData.updatedOn = null;
      this.personalData.note = null;
      this.personalData.username = form.value.userId;
  }

  private parseNormalDateToJsonDate(normalDateTime: string): string{
    let date: Date = new Date(normalDateTime);
    let jsonDate = date.toJSON();
    return jsonDate;
  }

  private createJsonNowDate(): string{
    let date: Date = new Date();
    let jsonDate = date.toJSON();
    return jsonDate;
  }

  ngOnInit(): void {
    this.createJsonNowDate();
  }

}
