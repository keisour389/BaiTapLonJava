import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { BusesScheduleService } from 'src/serivce/buses-schedule.service';
//import * as $ from 'jquery';
declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  size: number = 10;
  page: number = 1;
  destination: string = "Đà Lạt";

  

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  openSearchAdvance(){
    $('#searchAdvanceModal').modal('show')
  }

  onSubmit(): void{
    console.log(this.destination);
    let navigationExtras: NavigationExtras = {
      queryParams: {'destination': this.destination}
    }
    this.router.navigate(['/search-tickets'], navigationExtras);
    // this.busesScheduleService.getBusesScheduleByDestination(this.size, this.page, this.destination).subscribe(
    //   result => {}
    // );
  }

}
