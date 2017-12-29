export class Todo {
    // has three instance proeprties 
    id: number;
    title: string = '';
    complete: boolean=false;
    /*
    we are adding consturctor logic tha tlets us specifit property values diring instatition 
    so that we can easilly creat new todo instances :
    let todo = new Todo {{
        title:'finishproject 1',
        complete: false
    }};
    */
    constructor(values: Object = {}){
        Object.assign(this,values);
    }
}
