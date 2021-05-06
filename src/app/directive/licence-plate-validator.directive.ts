import { Directive } from '@angular/core';
import { AbstractControl, FormControl, NG_VALIDATORS, ValidatorFn, Validators } from '@angular/forms';

@Directive({
  selector: '[appLicencePlateValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useClass: LicencePlateValidatorDirective,
      multi: true
    }
  ]
})
export class LicencePlateValidatorDirective implements Validators {

  validator: ValidatorFn;

  constructor() {
    this.validator = this.licencePlateValidator();
  }
  validate(c: FormControl): any {
    return this.validator(c);
  }

  licencePlateValidator(): ValidatorFn{
    return (control: AbstractControl) => {
      if(!control.value){
        return null;
      }
      else{
        // Regex string example: 51G-12345
        const regex = new RegExp('[0-9]{2}[A-Za-z]{1}(-)[0-9]{4,5}');
        // Test regex with control value
        const result = regex.test(control.value);
        if (!result){
          return {phoneError: true,
                  message: 'Định dạng bảng số xế không đúng'};
        }
        else{
          return null;
        }
      }
    }
  }


}
