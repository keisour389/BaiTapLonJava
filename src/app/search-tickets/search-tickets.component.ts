import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
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

  constructor(private busesScheduleService: BusesScheduleService,
     private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let destination!: any;
    if(this.activatedRoute.snapshot.queryParamMap.get('destination') !== null){
      destination = this.activatedRoute.snapshot.queryParamMap.get('destination');
      this.getBusesScheduleByDestiantion(destination);
    }
    else{
      console.error("Destiantion is null");
    }
  }

  chooseBusSchedule(index: number): void{
    let data: any = this.busData[index];
    let navigationExtras: NavigationExtras = {
      queryParams: {'destination': data.tripId}
    }
    localStorage.setItem('busSelected', JSON.stringify(data));
    this.router.navigate(['/order-tickets'], navigationExtras)
  }

  getBusesScheduleByDestiantion(destination: string): void {
    this.busesScheduleService.getBusesScheduleByDestination(this.page, this.size, destination).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          this.busData = res.data;
          console.log(res);
          console.log("Fetch data successfully");  
        }
        else{
          console.log("Fetch data failed");
        } 
      },
      error => {
        console.error("Server error !!!");
      }
    );
  }

  getAllBusesSchedule(): void {
    this.busesScheduleService.getAllBusesSchedule(1, 20).subscribe(
      result => {
        let res: any = result;
        if(res.data !== null){
          this.busData = res.data;
          console.log(this.busData);
          console.log("Fetch data successfully");
        }
        else{
          console.log("Fetch data failed");
        }
      },
      error => {
        console.error("Server error !!!");
      }
    );
  }

}
