import { LEADING_TRIVIA_CHARS } from '@angular/compiler/src/render3/view/template';
import { Component, ElementRef, OnInit, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { multicast } from 'rxjs/operators';
import { TicketsService } from 'src/serivce/tickets.service';

@Component({
  selector: 'app-order-tickets',
  templateUrl: './order-tickets.component.html',
  styleUrls: ['./order-tickets.component.css']
})
export class OrderTicketsComponent implements OnInit {
  //Use viewChildren to reference the list of properties
  @ViewChildren('seatA') seatA!: QueryList<ElementRef>;
  @ViewChildren('seatB') seatB!: QueryList<ElementRef>;


  busScheduleData!: any;
  ticketsData!: any;

  dummyData: any = [
    {
      ticketId: "1",
      seatId: "1",
      price: 120000,
      status: 1,
      payment: null,
      paymentDate: null,
      bookingDate: null,
      note: null,
      tripId: 1,
      cusId: null
    },
    {
      ticketId: "2",
      seatId: "2",
      price: 120000,
      status: 1,
      payment: null,
      paymentDate: null,
      bookingDate: null,
      note: null,
      tripId: 1,
      cusId: null
    },
    {
      ticketId: "3",
      seatId: "3",
      price: 120000,
      status: 1,
      payment: null,
      paymentDate: null,
      bookingDate: null,
      note: null,
      tripId: 1,
      cusId: null
    },
    {
      ticketId: "4",
      seatId: "4",
      price: 120000,
      status: 0,
      payment: null,
      paymentDate: null,
      bookingDate: null,
      note: null,
      tripId: 1,
      cusId: null
    }
  ];
  data: any;
  isSelectedTickets: boolean = false;
  //0: Cus haven't select seat
  //1: This seat isn't empty
  //2: This seat is empty
  isTicketAcceptable: number = 0;
  ticketPrice!: number; //Default ticketPrice get from database
  totalPrice: number = 0;
  ticketsSelectedList: Array<any> = []; //This var render the tickets customer selected
  ticketsSelectedDataList: Array<any> = []; //This var store the tickets customer selected

  totalSeat: Array<number>;
  ticketRow: any;
  totalRow: any;
  lastRow: any;
  seatNumber: number = 0;
  seperate: any;
  diagramLocation: Array<any>;
  viewLocation!: Array<any>;

  constructor(private render: Renderer2, private activatedRoute: ActivatedRoute,
     private ticketsService: TicketsService, private router: Router) {
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
    this.diagramLocation = this.createLocationFormDiagram();
    console.log(this.diagramLocation);
    //this.data = this.spearateTicketsToDiagram(this.dummyData);
    // console.log("Data seperate from API:");
    // console.log(this.data);
    // this.viewLocation = this.createViewChildrenLoction();
    // console.log("View Children:");
    // console.log(this.viewLocation);
  }

  renderBusTickets(): void{
    let destination!: any;
    if(this.activatedRoute.snapshot.queryParamMap.get('destination') !== null){
      destination = this.activatedRoute.snapshot.queryParamMap.get('destination');
      this.getTicketsByTripId(destination);
    }
    else{
      console.error("Destiantion is null");
    }
  }

  getTicketsByTripId(tripId: string): void{
    this.ticketsService.getTicketsByTripId(1, 20, tripId).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          this.ticketsData = res.data;
          console.log(this.ticketsData);
          this.data = this.spearateTicketsToDiagram(this.ticketsData);
          console.log("Data seperate from API:");
          console.log(this.data);
          this.viewLocation = this.createViewChildrenLoction();
          console.log("View Children:");
          console.log(this.viewLocation);
        }  
        console.log(res);
      }
    )
  }

  ngOnInit(): void {
    if(JSON.parse(localStorage.getItem('busSelected')!) !== null){
      this.busScheduleData = JSON.parse(localStorage.getItem('busSelected')!);
      this.ticketPrice = this.busScheduleData.price;
      console.log(this.busScheduleData.price);
    }
    else{
      console.error("Buses schedule is null");
    }
     
    this.renderBusTickets();
    
    // this.data.push(this.spearateTicketsToDiagram(this.dummyData));
    // console.log(this.data);
  }

  //isLeft: Check the seat is left or right
  //i: Number of row
  //j: Number of couple column
  selectedTicketInDiagram(isLeft: boolean, i: number, j: number, z: number, localRef?: any) {

    //This var to show the position of data array
    let location: number = this.diagramLocation[i][j][z];
    console.log("location " + location);
    //This var to show the positon of view children
    let viewChildenLocation: number = this.viewLocation[i][j];
    let backgroundColor = "rgb(255, 0, 0)"; //Set default background color
    let currentColor: any;
    let ticketSelected: string;
    let ticketFromData: any;
    //Get ticket from data
    ticketFromData = this.ticketsData[location];
    if (ticketFromData.status === 0) {
      //This seat isn't empty
      this.isTicketAcceptable = 1;
      // setTimeout(() => {
      //   this.isTicketAcceptable = true;
      // }, 2000);
      console.log("Set error");
    }
    else {
      //This seat is empty
      this.isTicketAcceptable = 2;
      //Set selected status
      this.isSelectedTickets = true;
      //Check A seat or B seat
      //Get current background color
      // isLeft ? currentColor = this.seatA.get(location)!.nativeElement.style.backgroundColor
      //   : currentColor = this.seatB.get(location)!.nativeElement.style.backgroundColor;
      if (isLeft) {
        //A ticket
        currentColor = this.seatA.get(viewChildenLocation)!.nativeElement.style.backgroundColor;
        ticketSelected = "A" + (this.ticketsData[location].seatId);
      }
      else {
        //B ticket
        currentColor = this.seatB.get(viewChildenLocation)!.nativeElement.style.backgroundColor;
        ticketSelected = "B" + (this.ticketsData[location].seatId);
      }
      //Check current background color
      //currentColor != backgroundColor  ? backgroundColor = "rgb(255, 0, 0)" : backgroundColor = "rgb(255, 255, 255)";
      if (currentColor != backgroundColor) {
        //Select tickets
        backgroundColor = "rgb(255, 0, 0)";
        //Plus price for ticket
        this.totalPrice += this.ticketPrice;
        //Add ticket selected in list
        this.ticketsSelectedList.push(ticketSelected);
        //Add ticket to payment
        this.ticketsSelectedDataList.push(this.ticketsData[location].ticketId);
      }
      else {
        //Remove selected
        backgroundColor = "rgb(255, 255, 255)";
        //Minus total ticket price
        this.totalPrice -= this.ticketPrice;
        //Remove ticket unslected
        this.ticketsSelectedList = this.arrayRemove(this.ticketsSelectedList, ticketSelected);
        if (this.ticketsSelectedList.length < 1) {
          //None selection
          this.isSelectedTickets = false;
          //Set alert haven't select seat
          this.isTicketAcceptable = 0;
        }
      }
      //Check seat in right or left to set background color
      if (isLeft) {
        this.render.setStyle(this.seatA.get(viewChildenLocation)!.nativeElement, "backgroundColor", backgroundColor);
      }
      else {
        this.render.setStyle(this.seatB.get(viewChildenLocation)!.nativeElement, "backgroundColor", backgroundColor);
      }
    }
  }

  //This function use for count pipe to make ascending number
  countNumber() {
    return this.seperate.next().value;
  }

  //This function seperate to know the correct loction of diagram
  //It's used by the relevant function of reacted diagram
  createLocationFormDiagram() {
    let amount = 0;
    let coupleArray: Array<number> = [];
    let rowArray: Array<Array<number>> = [];
    let resultArray: Array<Array<Array<number>>> = [];
    for (var i = 0; i < 10; i++) {
      for (var j = 0; j < 2; j++) {
        for (var z = 0; z < 2; z++) {
          coupleArray.push(amount);
          amount++;
        }
        rowArray.push(coupleArray);
        coupleArray = [];
      }
      resultArray.push(rowArray);
      rowArray = [];
    }
    return resultArray;
  }

  //This function seperate to know the correct viewchildren position of diagram
  createViewChildrenLoction() {
    let amount = 0;
    let rowArray: Array<number> = [];
    let resultArray: Array<Array<number>> = [];
    for (var i = 0; i < 10; i++) {
      for (var z = 0; z < 2; z++) {
        rowArray.push(amount);
        amount++;
      }
      resultArray.push(rowArray);
      rowArray = [];
    }
    return resultArray;
  }

  spearateTicketsToDiagram(data: Array<any>) {
    let amount = 0;
    let coupleArray: Array<any> = [];
    let rowArray: Array<Array<any>> = [];
    let resultArray: Array<Array<Array<any>>> = [];
    for (var z = 0; z < 1; z++) {
      for (var i = 0; i < 2; i++) {
        for (var j = 0; j < 2; j++) {
          coupleArray.push(data[amount]);
          amount++;
        }
        rowArray.push(coupleArray);
        coupleArray = [];
      }
      resultArray.push(rowArray)
      rowArray = [];
    }

    return resultArray;
  }

  arrayRemove(arr: any, value: any) {

    return arr.filter((ele: any) => {
      return ele != value;
    });
  }

  payment(): void{
    localStorage.setItem('paymentInfo', JSON.stringify(
      {
        "start": this.busScheduleData.start,
        "destination": this.busScheduleData.destination,
        "departureDay": this.busScheduleData.departureDay,
        "totalPrice": this.totalPrice,
        "totalTicket": this.ticketsSelectedList.length,
        "ticketSelectedList": this.ticketsSelectedList,
        "ticketSelectedDataList": this.ticketsSelectedDataList}
      ));
    this.router.navigate(['/payment']);
  }
}
