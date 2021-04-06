import { Component, OnInit } from '@angular/core';
//import * as $ from 'jquery';
declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  openSearchAdvance(){
    $('#searchAdvanceModal').modal('show')
  }

}
