import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { EmployeeService } from 'src/serivce/employee.service';

declare const $: any;

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
    birthday: '',
    address: '',
    id: '',
    gender: '',
    type: 0,
    createdOn: '',
    updatedOn: '',
    note: null,
    username: ''
  };

  createdOn!: any;

  constructor(private datePipe: DatePipe, private employeeService: EmployeeService) {
    this.createdOn = this.datePipe.transform(new Date('2014-01-01T23:28:56.782Z'), 'yyyy-MM-dd');
    console.log(this.createdOn);
   }

  updatePersonalData(): void{
    this.indexData.birthday = this.parseDateToJsonDate(this.indexData.birthday);
    this.indexData.createdOn = this.parseDateToJsonDate(this.indexData.createdOn);
    this.indexData.updatedOn = new Date().toJSON();
    this.employeeService.updatePersonalDate(this.indexData).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          console.log("Updated successfully");
          this.closeModal();
        }
      }
    );
  }
  ngOnInit(): void {
    console.log(this.isUpdate);
    console.log(this.indexData);
  }
  parseDateToJsonDate(dateString: string): string{
    let date: Date = new Date(dateString);
    return date.toJSON();
  }

  closeModal(){
    $('#infoModal').modal('toggle');
  }

}
