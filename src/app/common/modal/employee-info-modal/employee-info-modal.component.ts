import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-info-modal',
  templateUrl: './employee-info-modal.component.html',
  styleUrls: ['./employee-info-modal.component.css']
})
export class EmployeeInfoModalComponent implements OnInit {

  @Input() isUpdate!: boolean;
  @Input() indexData: any = {
    userId: '',
    firstName: '',
    lastName: '',
    phoneNumber: '',
    dOB: '',
    address: '',
    id: '',
    gender: '',
    type: 0,
    createdOn: '',
    updatedOn: '',
    note: null
  };

  createdOn!: any;

  constructor(private datePipe: DatePipe) {
    this.createdOn = this.datePipe.transform(new Date('2014-01-01T23:28:56.782Z'), 'yyyy-MM-dd');
    console.log(this.createdOn);
   }

  ngOnInit(): void {
    console.log(this.isUpdate);
    console.log(this.indexData);
  }

}
