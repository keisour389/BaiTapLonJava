import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-order-success',
  templateUrl: './order-success.component.html',
  styleUrls: ['./order-success.component.css']
})
export class OrderSuccessComponent implements OnInit {
  orderSuccessInfo!: any;
  imageUrl: Array<string> = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    //this.imageUrl = this.getQrCode(100, 100, "test");
    //Get data from orderticket
    if (JSON.parse(localStorage.getItem('orderSuccessInfo')!) !== null) {
      this.orderSuccessInfo = JSON.parse(localStorage.getItem('orderSuccessInfo')!);
      console.log(this.orderSuccessInfo);
      //Genate qr code
      for (let data of this.orderSuccessInfo.paymentInfo.ticketSelectedList) {
        this.imageUrl.push(this.getQrCode(100, 100, data));
      }
    }
    else {
      console.error("Order success is null");
    }
  }

  getQrCode(sizeX: number, sizeY: number, code: string): string {
    let url = "https://api.qrserver.com/v1/create-qr-code/?size=" + sizeX + "x" + sizeY + "&data=" + code
    return url;

  }

}
