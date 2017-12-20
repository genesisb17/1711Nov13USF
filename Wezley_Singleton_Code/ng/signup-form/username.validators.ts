import { AbstractControl, ValidationErrors } from "@angular/forms";

// an example of a custom validator for use in the validation
// of a reactive form
export class UsernameValidators {
    static cannotContainSpace(control: AbstractControl): ValidationErrors | null {
        if((control.value as string).indexOf(' ') >= 0)
            return { "cannotContainSpace": true };
        return null;
    }

    static shouldBeUnique(control: AbstractControl): Promise<ValidationErrors | null> {
        return new Promise((resolve, reject) => {
            // a simple example of an asynchronous operation
            setTimeout(() => {
                if(control.value === 'wsingleton')
                    resolve({ "shouldBeUnique": true });
                else resolve(null);
            }, 2000);
        });
    }
}