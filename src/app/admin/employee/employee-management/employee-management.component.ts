import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-management',
  templateUrl: './employee-management.component.html',
  styleUrls: ['./employee-management.component.css']
})
export class EmployeeManagementComponent implements OnInit {

  optionData: any = [
    {
      text: 'Quản lí nhân viên',
      image: '/assets/images/MANAGE.png'
    },
    {
      text: 'Tạo tài khoản',
      image: '/assets/images/CREATE.png'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
