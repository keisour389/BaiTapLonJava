import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-employee-created',
  templateUrl: './employee-created.component.html',
  styleUrls: ['./employee-created.component.css']
})
export class EmployeeCreatedComponent implements OnInit {

  constructor() { }

  onSubmit(model: NgModel): void{
    console.log(model);
  }

  ngOnInit(): void {
  }

}
