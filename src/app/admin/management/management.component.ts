import { AfterViewInit, Component, HostListener, OnInit, Type } from '@angular/core';
import { ChartType, Row } from "angular-google-charts";

@Component({
  selector: 'app-management',
  templateUrl: './management.component.html',
  styleUrls: ['./management.component.css']
})
export class ManagementComponent implements OnInit, AfterViewInit {

  

  navbar: any;
  sticky: any;

  title = 'Thống kê lợi nhuận theo quý';
  type = ChartType.LineChart;
  data = [
    ["1", 7.0, 0.2],
    ["2", 6.9, 0.8],
    ["3", 9.5, 5.7],
    ["4", 14.5, 11.3]
  ];
  columnNames = ["Thống kê", "2020", "2021"];
  options = {
    hAxis: {
      title: 'Quý'
    },
    vAxis: {
      title: 'Tỷ'
    },
  };
  width = 700;
  height = 400;

  constructor() { 
  
  }
  ngAfterViewInit(): void {
    this.navbar = document.getElementById("navigation");
    this.sticky = this.navbar!.offsetTop;
    console.log(this.navbar);
  }

  @HostListener('window:scroll', ['$event'])
  myFunction() {
    if (window.pageYOffset >= this.sticky) {
      this.navbar!.classList.add("sticky")
    } else {
      this.navbar!.classList.remove("sticky");
    }
  }

  onScroll(){
    console.log("test");
  }

  ngOnInit(): void {
  }

}
