import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-order-success',
  templateUrl: './order-success.component.html',
  styleUrls: ['./order-success.component.css']
})
export class OrderSuccessComponent implements OnInit {
  imageUrl!: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.imageUrl = this.getQrCode(100, 100, "test");
  }

  getQrCode(sizeX: number, sizeY: number, code: String): String{
    let url="https://api.qrserver.com/v1/create-qr-code/?size=" + sizeX + "x" + sizeY+ "&data=" + code
    return url;
    
  }

}
