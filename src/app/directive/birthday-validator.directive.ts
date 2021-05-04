import { Directive } from '@angular/core';
import { AbstractControl, FormControl, NG_VALIDATORS, ValidatorFn, Validators } from '@angular/forms';
import { pipe } from 'rxjs';

@Directive({
  selector: '[appBirthdayValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useClass: BirthdayValidatorDirective,
      multi: true
    }
  ]
})
export class BirthdayValidatorDirective implements Validators {

  validator: ValidatorFn;

  nowDate: Date = new Date();

  constructor() {
    this.validator = this.birthdayValidator();
  }
  validate(c: FormControl): any {
    return this.validator(c);
  }

  birthdayValidator(): ValidatorFn {
    return (control: AbstractControl) => {
      // If control doesn't have value
      if (!control.value){
        return null;
      }
      // Get date value
      else{
        try{
          const dateData: Date = new Date(control.value);
          if (dateData > this.nowDate){
            return{dateError: true,
              // message: 'DATE_GREATER_THAN_NOW_DATE',
              message: 'Ngày sinh không thể lớn hơn ngày hiện tại'};
          }
          // Error free
          else{
            return null;
          }
        }
        catch {
          return{dateError: true,
            message: 'DATE_PARSE_ERROR'};
        }
      }
    };
  }

}
