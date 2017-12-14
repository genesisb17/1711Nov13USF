export class Todo {
    id: number;
    title: String = '';
    complete: boolean = false;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    } 

}
