import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profit-statistic',
  templateUrl: './profit-statistic.component.html',
  styleUrls: ['./profit-statistic.component.css']
})
export class ProfitStatisticComponent implements OnInit {

  optionData: any = [
    {
      text: 'Thống kê vé xe',
      image: '/assets/images/TICKET_STATICTIS.png'
    },
    {
      text: 'Thống kê tuyến xe',
      image: '/assets/images/BUS_STATICTIS.png'
    },
    {
      text: 'Thông kê vé bị hủy',
      image: '/assets/images/CANCEL_STATICTIS.png'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
