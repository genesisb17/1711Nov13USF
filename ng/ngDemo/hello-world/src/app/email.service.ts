import { Injectable } from '@angular/core';

@Injectable()//decorator that we would need if this component needed a dependency in its constructor // angular should be able to inject dependencies into its constructor
export class EmailService {

  constructor() { }

}
