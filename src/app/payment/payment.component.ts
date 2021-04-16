import { Location } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
// import { createHmac } from 'crypto';
import * as crypto from 'crypto-js';

declare var $: any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  paymentType: number = 0;
  signature!: String;


  momoPaymentRequest: any = {
    accessKey: "mvD9FZ0hdixKT4yN",
    partnerCode: "MOMOLKXZ20210415",
    requestType: "captureMoMoWallet",
    notifyUrl: "https://momo.vn",
    returnUrl: "https://momo.vn",
    orderId: "n",
    amount: "1000",
    orderInfo: "SDK team.",
    requestId: "MM1540456472575",
    extraData: "email=abc@gmail.com",
    signature: ""
  }

  message!: string;
  momoSerectKey: string = "44dIJp5rRk5DtHUmqJR5IqBPgp9KnFo4";

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, private location: Location) { }

  ngOnInit(): void {
    this.payment();
    this.signature = this.createHmacSha256String("", "");
  }

  //Working
  payment() {
    if (this.paymentType === 1) {
      //Test generate random order id
      let r = Math.random().toString(36).substring(7);
      
      this.momoPaymentRequest.orderId = r;
      this.message = "partnerCode=" + this.momoPaymentRequest.partnerCode +
      "&accessKey=" + this.momoPaymentRequest.accessKey +
      "&requestId=" + this.momoPaymentRequest.requestId +
      "&amount=" + this.momoPaymentRequest.amount +
      "&orderId=" + this.momoPaymentRequest.orderId +
      "&orderInfo=" + this.momoPaymentRequest.orderInfo +
      "&returnUrl=" + this.momoPaymentRequest.returnUrl +
      "&notifyUrl=" + this.momoPaymentRequest.notifyUrl +
      "&extraData=" + this.momoPaymentRequest.extraData;
      //Create signature
      this.momoPaymentRequest.signature = this.createHmacSha256String(this.message, this.momoSerectKey);
      this.momoPayment();
    }
  }

  momoPayment() {
    this.http.post("/gw_payment/transactionProcessor",
      this.momoPaymentRequest).subscribe(
        result => {
          var res: any = result;
          if(res.errorCode !== 0){
            alert("Đã xảy ra lỗi bất thường."); 
          }
          else{         
            window.open(res.payUrl, '_blank');
            setTimeout(() => {
              this.closeConfirmModal();
              this.router.navigate(['/order-success'], {relativeTo: this.route});  
            }, 3000);                   
          }         
        },
        error => {
          console.log(error);
        }
      )
  }

  openConfirmModal() {
    $('#comfirmModal').modal('show');
  }
  closeConfirmModal(){
    $('#comfirmModal').modal('toggle')
  }

  createHmacSha256String(message: string, serectKey: string) {
    let CryptoJS = require('crypto-js');
    let signature = crypto.algo.HMAC.create(CryptoJS.algo.SHA256
      , serectKey);
    signature.update(message);
    var signatureHex = signature.finalize();
    return signatureHex.toString(CryptoJS.enc.Hex);
  }


}
