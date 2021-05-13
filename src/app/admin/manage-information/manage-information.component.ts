import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BusesScheduleService } from 'src/serivce/buses-schedule.service';
import { EmployeeService } from 'src/serivce/employee.service';
import { TicketsService } from 'src/serivce/tickets.service';

declare const $: any;

@Component({
  selector: 'app-manage-information',
  templateUrl: './manage-information.component.html',
  styleUrls: ['./manage-information.component.css']
})
export class ManageInformationComponent implements OnInit {

  // This var to get specific or updated data
  indexData: any = {
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

  isUpdate = false;

  managedType!: any;

  managedTitle!: any;

  busTitle: Array<string> = ['Mã chuyến xe', 'Tài xế', 'Phụ xe', 'Điểm đi', 'Điểm đến', 'Ngày khởi hành', 'Loại xe', 'Chức năng'];

  ticketTitle: Array<string> = ['Mã vé', 'Mã ghế', 'Trạng thái', 'Thanh toán', 'Chức năng'];

  empTitle: Array<string> = ['Tài khoản', 'Họ tên', 'Số điện thoại', 'Ngày sinh', 'Địa chỉ', 'CMND', 'Chức năng'];

  empData: any = [{
    userId: 'HSA123',
    firstName: 'Nguyễn',
    lastName: 'Văn E',
    phoneNumber: '012345453',
    dOB: '2012-04-23T18:25:43.511Z',
    address: '12 Gia Phú',
    id: '123456',
    gender: 'Nam',
    type: 1,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: '2012-04-23T18:25:43.511Z',
    note: null
  },
  {
    userId: 'HSA123',
    firstName: 'Nguyễn',
    lastName: 'Văn E',
    phoneNumber: '012345453',
    dOB: '2012-04-23T18:25:43.511Z',
    address: '12 Gia Phú',
    id: '123456',
    gender: 'Nam',
    type: 1,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: '2012-04-23T18:25:43.511Z',
    note: null
  },
  {
    userId: 'HSA123',
    firstName: 'Nguyễn',
    lastName: 'Văn E',
    phoneNumber: '012345453',
    dOB: '2012-04-23T18:25:43.511Z',
    address: '12 Gia Phú',
    id: '123456',
    gender: 'Nam',
    type: 1,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: '2012-04-23T18:25:43.511Z',
    note: null
  }];

  ticketData: any = [{
    ticketId: '1',
    seatId: '1',
    price: 500000,
    status: 0,
    payment: 0,
    paymentDate: '2012-04-23T18:25:43.511Z',
    bookingDate: '2012-04-23T18:25:43.511Z',
    note: null,
    tripId: 'HCMDALAT2021',
    cusId: 'Nguyễn Văn D'
  },
  {
    ticketId: '1',
    seatId: '1',
    price: 500000,
    status: 0,
    payment: 0,
    paymentDate: '2012-04-23T18:25:43.511Z',
    bookingDate: '2012-04-23T18:25:43.511Z',
    note: null,
    tripId: 'HCMDALAT2021',
    cusId: 'Nguyễn Văn D'
  },
  {
    ticketId: '1',
    seatId: '1',
    price: 500000,
    status: 0,
    payment: 0,
    paymentDate: '2012-04-23T18:25:43.511Z',
    bookingDate: '2012-04-23T18:25:43.511Z',
    note: null,
    tripId: 'HCMDALAT2021',
    cusId: 'Nguyễn Văn D'
  }];

  busData: any = [{
    tripId: '1',
    licensePlate: '52X12345',
    driver: 'Nguyễn Văn A',
    subDriver: 'Nguyễn Văn B',
    from: 'TPHCM',
    to: 'Đà Lạt',
    departureDay: '2012-04-23T18:25:43.511Z',
    totalTime: 180,
    status: 1,
    vehicleType: '50 chỗ',
    totalSeat: 45,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: null,
    note: null,
    managed: 'Nguyễn Văn C'
  },
  {
    tripId: '1',
    licensePlate: '52X12345',
    driver: 'Nguyễn Văn A',
    subDriver: 'Nguyễn Văn B',
    from: 'TPHCM',
    to: 'Đà Lạt',
    departureDay: '2012-04-23T18:25:43.511Z',
    totalTime: 180,
    status: 1,
    vehicleType: '50 chỗ',
    totalSeat: 45,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: null,
    note: null,
    managed: 'Nguyễn Văn C'
  },
  {
    tripId: '1',
    licensePlate: '52X12345',
    driver: 'Nguyễn Văn A',
    subDriver: 'Nguyễn Văn B',
    from: 'TPHCM',
    to: 'Đà Lạt',
    departureDay: '2012-04-23T18:25:43.511Z',
    totalTime: 180,
    status: 1,
    vehicleType: '50 chỗ',
    totalSeat: 45,
    createdOn: '2012-04-23T18:25:43.511Z',
    updatedOn: null,
    note: null,
    managed: 'Nguyễn Văn C'
  }];

  title: Array<any> = [];
  data: Array<any> = [];

  // This function get param form URL to know what component need to render
  render(value: string): void {
    switch (value) {
      case '1':
        // Bus
        // Get data form API
        this.managedTitle = 'Thông tin các chuyến xe';
        this.title = this.busTitle;
        this.getBusesSchedule();
        break;
      case '2':
        // Ticket
        // Get data form API
        this.managedTitle = 'Thông tin vé';
        this.title = this.ticketTitle;
        this.getAllTickets();
        break;
      case '3':
        // Emplotyee
        // Get data form API
        this.managedTitle = 'Thông tin nhân viên';
        this.title = this.empTitle;
        this.getAllEmployee();
        

        break;
    }
  }

  openInfoModal(isUpdate: boolean, index: number): void {
    this.isUpdate = isUpdate;
    this.indexData = this.data[index];
    console.log(this.indexData);
    this.indexData = this.changeDateInData(this.indexData, this.managedType);
    console.log(this.indexData);
    $('#infoModal').modal('show');
  }

  constructor(private busesSchedule: BusesScheduleService,private ticketService: TicketsService, private employeeService: EmployeeService, private route: ActivatedRoute, private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.managedType = this.route.snapshot.paramMap.get('managedType');
    this.render(this.managedType);
  }

  transformToNormalDate(jsonDate: string): string | null {
    // yyyy-MM-dd is date standal format of date
    // Check null
    if (jsonDate !== null){
      const result = this.datePipe.transform(new Date(jsonDate), 'yyyy-MM-dd');
      return result;
    }
    else{
      return null;
    }
  }

  transformToNormalDateTime(jsonDate: string): string | null {
    // yyyy-MM-ddThh:mm is date standal format of datetime-loction
    // Check null
    if (jsonDate !== null){
      const result = this.datePipe.transform(new Date(jsonDate), 'yyyy-MM-ddThh:mm');
      return result;
    }
    else{
      return null;
    }
  }

  // This function use to change Json date to normal date for index data
  // Value is the type of render data
  // Data is data corresponding with seperated value
  changeDateInData(data: any, value: string): any {
    switch (value) {
      case '1':
        // Bus
        data.departureDay = this.transformToNormalDateTime(data.departureDay);
        data.createdOn = this.transformToNormalDate(data.createdOn);
        data.updatedOn = this.transformToNormalDate(data.updatedOn);
        break;
      case '2':
        // Ticket
        data.paymentDate = this.transformToNormalDateTime(data.paymentDate);
        data.bookingDate = this.transformToNormalDateTime(data.bookingDate);
        break;
      case '3':
        // Employee
        data.dOB = this.transformToNormalDate(data.birthday);
        data.createdOn = this.transformToNormalDate(data.createdOn);
        data.updatedOn = this.transformToNormalDate(data.updatedOn);
        break;
    }
    return data;
  }

  getAllEmployee(): void {
    this.employeeService.getAllEmployee(1, 20).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          this.data = res.data;
        }
      }
    )
  }

  getAllTickets(): void {
    this.ticketService.getAllTickets(1, 20).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          this.data = res.data;
        }
      }
    )
  }

  getBusesSchedule(): void {
    this.busesSchedule.getAllBusesSchedule(1, 20).subscribe(
      result => {
        let res: any = result;
        if(res !== null){
          this.data = res.data;
          console.log(res.data);
        }
      }
    )
  }


}
