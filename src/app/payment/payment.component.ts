import { Component, OnInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  openConfirmModal(){
    $('#comfirmModal').modal('show');
  }

}
