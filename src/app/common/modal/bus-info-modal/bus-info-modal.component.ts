import { Component, Input, OnInit } from '@angular/core';
import { BusesScheduleService } from 'src/serivce/buses-schedule.service';

@Component({
  selector: 'app-bus-info-modal',
  templateUrl: './bus-info-modal.component.html',
  styleUrls: ['./bus-info-modal.component.css']
})
export class BusInfoModalComponent implements OnInit {
  @Input() isUpdate!: boolean;
  @Input() indexData: any = {
    tripId: '',
    licensePlate: '',
    driver: '',
    subDriver: '',
    from: '',
    to: '',
    departureDay: '',
    totalTime: 0,
    status: 0,
    vehicleType: '',
    totalSeat: 0,
    createdOn: '',
    updatedOn: null,
    note: null,
    manager: ''
  };

  constructor(private busesScheduleService: BusesScheduleService) { }

  ngOnInit(): void {
  }

  updateBusesSchedule(): void{
    this.busesScheduleService.updateBusesSchedule(this.indexData).subscribe(
      result => {
        let res: any = result;
        console.log(res);
      }
    );

  }

}
