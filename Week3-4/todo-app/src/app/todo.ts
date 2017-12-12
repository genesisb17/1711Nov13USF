export class Todo {
    // our todo class has three instance properties 
    id: number;
    title: string ='';
    complete: boolean = false;

    constructor(values: Object = {}){
        Object.assign(this,values);
    }

}

