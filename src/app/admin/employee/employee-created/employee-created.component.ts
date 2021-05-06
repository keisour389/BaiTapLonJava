import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-employee-created',
  templateUrl: './employee-created.component.html',
  styleUrls: ['./employee-created.component.css']
})
export class EmployeeCreatedComponent implements OnInit {

  isConfirmPasswordCorrectly!: boolean;
  empPassword: any = {
    password: null,
    confirmPassword: null
  }


  constructor() { }

  onSubmit(model: NgModel): void {
    console.log(model);
    this.isConfirmPasswordCorrectly = this.checkConfirmPassword();
  }

  checkConfirmPassword(): boolean{
    if(this.empPassword.password === this.empPassword.confirmPassword){
      return true;
    }
    return false;
  }

  ngOnInit(): void {
  }

}
