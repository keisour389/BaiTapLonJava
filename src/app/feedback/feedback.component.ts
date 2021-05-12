import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
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
    fullname: null,
    phoneNumber: null,
    type: "Chất lượng dịch vụ", //Set default
    status: null,
    note: null,
    createdOn: null,
    empId: null

  }

  constructor(private customerService: CustomerService, private router: Router) { }

  onSubmit(form: NgForm): void {
    console.log(form);
    if (form.valid) {
      this.bindingData(form);
      console.log(this.feedbackData);
      this.sendFeedback();
    }
  }

  sendFeedback(): void {
    this.customerService.sendFeedback(this.feedbackData).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          console.log("Feedback is sent successfully.");
          alert("Cảm ơn bạn đã gửi phản hổi về công ty.");
          this.router.navigate(['/']);
        }
        else{
          console.log("Can't send feedback.");
        }
      },
      error => {
        console.log("Server error !!!");
      }
    )
  }

  private bindingData(form: NgForm): void {
    this.feedbackData.feedbackId = Math.random().toString(36).substring(10);
    this.feedbackData.fullname = form.value.fullName;
    this.feedbackData.phoneNumber = form.value.phoneNumber;
    this.feedbackData.type = form.value.feedbackType;
    this.feedbackData.content = form.value.description;
    this.feedbackData.status = 0; //Set default haven't process
    this.feedbackData.createdOn = this. createJsonNowDate();
    this.feedbackData.note = null;
    this.feedbackData.empId = null;
  }

  private createJsonNowDate(): string{
    let date: Date = new Date();
    let jsonDate = date.toJSON();
    return jsonDate;
  }

  ngOnInit(): void {
  }

}
