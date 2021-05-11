import { Component, OnInit } from '@angular/core';
import { BusesScheduleService } from 'src/serivce/buses-schedule.service';

@Component({
  selector: 'app-search-tickets',
  templateUrl: './search-tickets.component.html',
  styleUrls: ['./search-tickets.component.css']
})
export class SearchTicketsComponent implements OnInit {

  busData!: any;

  page: Number = 1;
  size: Number = 20;

  constructor(private busesScheduleService: BusesScheduleService) { }

  ngOnInit(): void {
    this.getAllBusesSchedule();
  }

  getAllBusesSchedule(): void {
    this.busesScheduleService.getAllBusesSchedule(1, 20).subscribe(
      result => {
        let res: any = result;
        if(res.data !== null){
          this.busData = res.data;
          console.log(this.busData);
        }
        else{
          console.log("Fetch data successfully");
        }
      },
      error => {
        console.error("Server error !!!");
      }
    );
  }

}
