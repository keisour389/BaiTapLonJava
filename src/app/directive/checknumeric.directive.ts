import { Directive } from '@angular/core';
import { AbstractControl, FormControl, NG_VALIDATORS, ValidatorFn, Validators } from '@angular/forms';

@Directive({
  selector: '[appChecknumeric]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useClass: ChecknumericDirective,
      multi: true
    }
  ]
})
export class ChecknumericDirective implements Validators {

  validator: ValidatorFn;

  constructor() {
    this.validator = this.checkNumberValidator();
  }
  validate(c: FormControl): any {
    return this.validator(c);
  }

  checkNumberValidator(): ValidatorFn {
    return (control: AbstractControl) => {
      // If control doesn't have value
      if (!control.value) {
        return null;
      }
      else {
        if (Number(control.value) <= 0) {
          return {
            error: true,
            message: 'Thời lượng phải lớn hơn 0'
          };
        }
        else if (isNaN(Number(control.value))) {
          return {
            error: true,
            message: 'Định dạng phải là số'
          };
        }
        else {
          return null;
        }
      }
    }
  }
}
