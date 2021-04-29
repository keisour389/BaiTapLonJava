import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket-info-modal',
  templateUrl: './ticket-info-modal.component.html',
  styleUrls: ['./ticket-info-modal.component.css']
})
export class TicketInfoModalComponent implements OnInit {
  @Input() isUpdate!: boolean;
  @Input() indexData: any = {
    ticketId: '',
    seatId: '',
    price: '',
    status: '',
    payment: '',
    paymentDate: '',
    bookingDate: '',
    note: '',
    tripId: '',
    cusId: ''
  };

  constructor() { }

  ngOnInit(): void {
  }

}
