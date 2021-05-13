import { Component, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { BusesScheduleService } from 'src/serivce/buses-schedule.service';

@Component({
  selector: 'app-bus-created',
  templateUrl: './bus-created.component.html',
  styleUrls: ['./bus-created.component.css']
})
export class BusCreatedComponent implements OnInit {

  data: any = {
    tripId: null,
    licensePlates: null,
    mainDriver: null,
    subDriver: null,
    start: null,
    destination: null,
    departureDay: null,
    totalTime: null,
    status: null,
    vehicleType: null,
    totalSeats: null,
    price: null,
    createdOn: null,
    updatedOn: null,
    note: null,
    manager: null
  }

  constructor(private busesScheduleService: BusesScheduleService) { }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.bindingData(form);
      this.createBusesSchedule();
      console.log(this.data);
    }
    console.log(form);
  }

  ngOnInit(): void {

  }

  createBusesSchedule(): void {
    this.busesScheduleService.createBusesSchedule(this.data).subscribe(
      result => {
        let res: any = result;
        if (res !== null) {
          alert("Tạo chuyến xe thành công.");
        }
        else {
          console.log("Created failed.")
        }
        console.log(res);
      },
      error => {
        console.error("Server Error !!!");
      }
    );
  }

  bindingData(form: NgForm): void {
    this.data.tripId = Math.random().toString(36).substring(10);
    this.data.start = form.value.start;
    this.data.destination = form.value.destination;
    this.data.mainDriver = form.value.driver;
    this.data.subDriver = form.value.subDriver;
    this.data.depatureDay = form.value.start;
    this.data.totalSeats = parseInt(form.value.totalSeat);
    this.data.totalTime = parseInt(form.value.totalTime);
    this.data.vehicleType = form.value.vehicleType;
    this.data.licensePlates = form.value.licensePlates;
    this.data.price = 100000; //Set default
    this.data.departureDay = this.parseDateToJsonDate(form.value.depatureDay);
    this.data.createdOn =  new Date().toJSON();
    this.data.updatedOn = null;
    this.data.status = 1;
    this.data.manager = "testingg"; //default
    this.data.note = form.value.note;
  }

  parseDateToJsonDate(dateString: string): string{
    let date: Date = new Date(dateString);
    return date.toJSON();
  }

}
