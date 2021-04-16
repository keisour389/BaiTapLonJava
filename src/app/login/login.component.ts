import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {
  //Reference DOM by ViewChild
  @ViewChild('emp') emp!: ElementRef;
  @ViewChild('cus') cus!: ElementRef; 

  public loginType: String = "khách hàng";

  constructor() { }

  changeLoginType(type: String){
    this.loginType = type;
    //Change border after choosing login type
    if(type === 'khách hàng'){
      this.cus.nativeElement.style.border = "1px solid #0068bd";
      this.emp.nativeElement.style.border = "none";
    }
    else{
      this.emp.nativeElement.style.border = "1px solid #0068bd";
      this.cus.nativeElement.style.border = "none";
    }
  }

  ngOnInit(): void {
  }

  //Setting login type is "Cus" after create template
  ngAfterViewInit(){
    this.cus.nativeElement.style.border = "1px solid #0068bd";
  }

}
