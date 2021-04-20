import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private _location: Location) { }

  backClicked(){
    //Return previous page
    this._location.back();
  }


  ngOnInit(): void {
  }

}
