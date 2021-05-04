import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-data-statistics',
  templateUrl: './data-statistics.component.html',
  styleUrls: ['./data-statistics.component.css']
})
export class DataStatisticsComponent implements OnInit {

  statisticType!: any;
  statisticTitle!: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.statisticType = this.route.snapshot.paramMap.get('statisticType');
    this.statisticTitle = this.getStatisticType(this.statisticType);
  }

  getStatisticType(type: any): string {
    switch (type) {
      case '1':
        return 'Thống kê vé xe';
      case '2':
        return 'Thống kê tuyến xe';
      case '3':
        return 'Thống kê vé bị hủy';
    }
    return '';
  }

}
