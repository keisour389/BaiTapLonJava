import { Directive } from '@angular/core';
import { AbstractControl, FormControl, NG_VALIDATORS, ValidatorFn, Validators } from '@angular/forms';

@Directive({
  selector: '[appPhonenumberValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useClass: PhonenumberValidatorDirective,
      multi: true
    }
  ]
})
export class PhonenumberValidatorDirective implements Validators {

  validator: ValidatorFn;

  constructor() {
    this.validator = this.phonenumberValidator();
  }
  validate(c: FormControl): any {
    return this.validator(c);
  }

  phonenumberValidator(): ValidatorFn{
    return (control: AbstractControl) => {
      if (!control.value){
        return null;
      }
      else{
        // Regex string example: 091234567
        const regex = new RegExp('(0)[0-9 ]{9}');
        // Test regex with control value
        const result = regex.test(control.value);
        if (!result){
          return {phoneError: true,
                  message: 'Định dạng số điện thoại không đúng'};
        }
        else{
          return null;
        }
      }
    };
  }
}
