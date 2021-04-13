import { Component, ElementRef, OnInit, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-order-tickets',
  templateUrl: './order-tickets.component.html',
  styleUrls: ['./order-tickets.component.css']
})
export class OrderTicketsComponent implements OnInit {
  //Use viewChildren to reference the list of properties
  @ViewChildren('seatA') seatA!: QueryList<ElementRef>;
  @ViewChildren('seatB') seatB!: QueryList<ElementRef>;

  isClicked: boolean = false;
  
  totalSeat: Array<number>;
  ticketRow: any;
  totalRow: any;
  lastRow: any;
  seatNumber: number = 0;
  seperate: any;
  diagramLocation: Array<Array<number>>;

  constructor(private render: Renderer2) {
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
  }

  ngOnInit(): void {
  }

  //isLeft: Check the seat is left or right
  //i: Number of row
  //j: Number of couple column
  selectedTicketInDiagram(isLeft: boolean, i: number, j:number){
    var location: number = this.diagramLocation[i][j];
    var backgroundColor = "rgb(255, 0, 0)"; //Set default background color
    var currentColor: any;
    //Check A seat or B seat
    //Get current background color
    isLeft ? currentColor = this.seatA.get(location)!.nativeElement.style.backgroundColor
      : currentColor = this.seatB.get(location)!.nativeElement.style.backgroundColor
    //Check current background color
    currentColor != backgroundColor  ? backgroundColor = "rgb(255, 0, 0)" : backgroundColor = "rgb(255, 255, 255)"
    //Check seat in right or left to set background color
    if(isLeft){
      this.render.setStyle(this.seatA.get(location)!.nativeElement, "backgroundColor", backgroundColor);
    }
    else{
      this.render.setStyle(this.seatB.get(location)!.nativeElement, "backgroundColor", backgroundColor);
    }
  }

  //This function use for count pipe to make ascending number
  countNumber(){
    return this.seperate.next().value;
  }

  //This function use to know the correct loction of diagram
  //It's used by the relevant function of reacted diagram
  createLocationFormDiagram(){
    let amount = 0;
    let rowArray: Array<number> = [];
    let resultArray: Array<Array<number>> = [];
    //this.a = Array.from(Array(4), (x, i) => i+1)
    for(var i=0; i<10; i++){
      for(var j=0; j<2; j++){
        rowArray.push(amount);
        amount++;
      }
      resultArray.push(rowArray);
      rowArray=[];
    }
    return resultArray;
  }
}
