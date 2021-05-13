import { Component, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/serivce/employee.service';

@Component({
  selector: 'app-employee-created',
  templateUrl: './employee-created.component.html',
  styleUrls: ['./employee-created.component.css']
})
export class EmployeeCreatedComponent implements OnInit {

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
    address: null,
    id: null,
    gender: 'Nam',
    createdOn: null,
    updatedOn: null,
    note: null,
    username: null
  }

  isConfirmPasswordCorrectly!: boolean;
  empPassword: any = {
    password: null,
    confirmPassword: null
  }


  constructor(private empService: EmployeeService, private router: Router) { }

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

  checkConfirmPassword(): boolean {
    if (this.empPassword.password === this.empPassword.confirmPassword) {
      return true;
    }
    return false;
  }

  registerLoginData(): void {
    this.empService.registerLoginData(this.loginData).subscribe(
      result => {
        let res: any =  result;
        if(res !== null){
          console.log("Register login data successfully");
          //Continue create personal data
          this.empService.registerPersonalData(this.personalData).subscribe(
            result => {
              let res: any =  result;
              if (res !== null) {
                console.log("Register personal data successfully");
                alert("Đăng kí tài khoản thành công");
                this.router.navigate(['/management']);
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

  private bindingLoginData(form: NgForm): void {
    this.loginData.userId = form.value.userId;
    this.loginData.password = form.value.password;
    this.loginData.type = 2; //Customers always have type is 1
    this.loginData.status = 1; //1 is default status. Normal status
    this.loginData.createdOn = this.createJsonNowDate();
    this.loginData.updatedOn = null;
    this.loginData.note = form.value.note;
  }

  private bindingPersonnalData(form: NgForm): void {
    this.personalData.userId = form.value.userId;
    this.personalData.firstName = form.value.fName;
    this.personalData.lastName = form.value.lName;
    this.personalData.displayName = this.personalData.firstName + " " + this.personalData.lastName;
    this.personalData.phoneNumber = form.value.phoneNumber;
    this.personalData.birthday = this.parseNormalDateToJsonDate(form.value.dOB);
    this.personalData.address = form.value.address;
    this.personalData.id = form.value.id;
    this.personalData.gender = form.value.gender;
    this.personalData.createdOn = this.createJsonNowDate();
    this.personalData.updatedOn = null;
    this.personalData.note = null;
    this.personalData.username = form.value.userId;
  }

  private parseNormalDateToJsonDate(normalDateTime: string): string {
    let date: Date = new Date(normalDateTime);
    let jsonDate = date.toJSON();
    return jsonDate;
  }

  private createJsonNowDate(): string {
    let date: Date = new Date();
    let jsonDate = date.toJSON();
    return jsonDate;
  }

  ngOnInit(): void {
  }

}
