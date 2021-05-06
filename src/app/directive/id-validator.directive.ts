import { Directive } from '@angular/core';
import { AbstractControl, FormControl, NG_VALIDATORS, ValidatorFn, Validators } from '@angular/forms';

@Directive({
  selector: '[appIdValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useClass: IdValidatorDirective,
      multi: true
    }
  ]
})
export class IdValidatorDirective implements Validators {

  validator: ValidatorFn;

  constructor() {
    this.validator = this.idValidator();
  }
  validate(c: FormControl): any {
    return this.validator(c);
  }

  idValidator(): ValidatorFn {
    return (control: AbstractControl) => {
      if (!control.value) {
        return null;
      }
      else {
        // Regex string example: 51G-12345
        const regex = new RegExp('[0-9]');
        // Test regex with control value
        const result = regex.test(control.value);
        if (!result) {
          return {
            error: true,
            message: 'CMND có định dạng là số'
          }
        }
        else {
          return null;
        }
      }
    }
  }


}
