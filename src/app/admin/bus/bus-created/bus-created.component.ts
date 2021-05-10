import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-bus-created',
  templateUrl: './bus-created.component.html',
  styleUrls: ['./bus-created.component.css']
})
export class BusCreatedComponent implements OnInit {

  constructor() { }

  onSubmit(model: NgModel): void {
    console.log(model);
  }

  ngOnInit(): void {
  }

}
