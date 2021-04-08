import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-tickets',
  templateUrl: './order-tickets.component.html',
  styleUrls: ['./order-tickets.component.css']
})
export class OrderTicketsComponent implements OnInit {

  totalSeat: Array<number>;
  ticketRow: any;
  totalRow: any;
  lastRow: any;
  seatNumber: number = 0;
  seperate: any;

  constructor() {
    //Total seat get form other place
    this.totalSeat = Array.from(Array(40), (x, i) => i)
    this.seperate = this.totalSeat.values();
    //Set default a bus has 10 normal rows
    this.totalRow = Array.from(Array(10), (x, i) => i)
    //Set default 1 row has 4 seats
    this.ticketRow = Array.from(Array(2), (x, i) => i)
    //Set default last row has 5 seats
    this.lastRow = Array.from(Array(5), (x, i) => i)
    console.log(this.ticketRow);
  }

  ngOnInit(): void {
  }

  //This function use for count pipe to make ascending number
  countNumber(){
    return this.seperate.next().value;
  }
}
