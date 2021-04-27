import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-bus-management',
  templateUrl: './bus-management.component.html',
  styleUrls: ['./bus-management.component.css']
})
export class BusManagementComponent implements OnInit {
  optionData: any = [{
    text: 'Tạo chuyến xe',
    image: '/assets/images/CREATE.png'
  },
  {
    text: 'Quản lí chuyến xe',
    image: '/assets/images/MANAGE.png'
  }];
  constructor() { }

  ngOnInit(): void {
  }

}
