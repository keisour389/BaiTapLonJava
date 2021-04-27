import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-manage-information',
  templateUrl: './manage-information.component.html',
  styleUrls: ['./manage-information.component.css']
})
export class ManageInformationComponent implements OnInit {

  managedType!: any;

  managedTitle!: any;

  busTitle: Array<string> = ['Mã chuyến xe', 'Tài xế', 'Phụ xe', 'Điểm đi', 'Điểm đến', 'Ngày khởi hành', 'Loại xe', 'Chức năng'];

  ticketTitle: Array<string> = ['Mã vé', 'Mã ghế', 'Giá vé', 'Trạng thái', 'Thanh toán', 'Chức năng'];

  empTitle: Array<string> = ['Tài khoản', 'Họ tên', 'Số điện thoại', 'Ngày sinh', 'Địa chỉ', 'CMND', 'Chức năng'];

  empData: any = [{
    userId: 'HSA123',
    fullName: 'Nguyễn Văn E',
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
    fullName: 'Nguyễn Văn E',
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
    fullName: 'Nguyễn Văn E',
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

  title!: any;
  data!: any;

  // This function get param form URL to know what component need to render
  render(value: string): void {
    switch (value) {
      case '1':
        // Bus
        // Get data form API
        this.managedTitle = 'Thông tin các chuyến xe';
        this.title = this.busTitle;
        this.data = this.busData;
        break;
      case '2':
        // Ticket
        // Get data form API
        this.managedTitle = 'Thông tin vé';
        this.title = this.ticketTitle;
        this.data = this.ticketData;
        break;
      case '3':
        // Emplotyee
        // Get data form API
        this.managedTitle = 'Thông tin nhân viên';
        this.title = this.empTitle;
        this.data = this.empData;
        break;
    }
  }

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.managedType = this.route.snapshot.paramMap.get('managedType');
    this.render(this.managedType);
  }

}
