import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerService } from 'src/serivce/customer.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  feedbackData: any = {
    feedbackId: null,
    content: null,
    status: null,
    note: null,
    cusId: null,
    empId: null
  
  }

  constructor(private customerService: CustomerService) { }

  onSubmit(form: NgForm): void{
    console.log(form);
    if(form.valid){

    }
  }

  sendFeedBack(): void{
    this.customerService.sendFeedback(this.feedbackData).subscribe(
      result => {

      },
      error => {

      }
    )
  }

  private bindingData(form: NgForm): void {
    this.feedbackData.feedbackId = Math.random().toString(36).substring(10);
    //this.content = 
  }

  ngOnInit(): void {
  }

}
