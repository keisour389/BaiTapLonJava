import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket-management',
  templateUrl: './ticket-management.component.html',
  styleUrls: ['./ticket-management.component.css']
})
export class TicketManagementComponent implements OnInit {

  optionData: any = [
  {
    text: 'Quản lí vé xe',
    image: '/assets/images/MANAGE.png'
  },
  {
    text: 'Cập nhật vé xe',
    image: '/assets/images/UPDATE.png'
  },
  {
    text: 'Lịch sử hủy vé',
    image: '/assets/images/CANCEL.png'
  }
];

  constructor() { }

  ngOnInit(): void {
  }

}
