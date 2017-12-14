export class Todo {
    // our todo class has three instance properties
    id: number;
    title: string = '';
    complete: boolean = false;

    /*We are adding constructor logic that lets us specify property values
    during instantiation so that we can easily create new todo instances like:
    
        let todo = new Todo({
            title: 'Finish Project 1',
            complete: false
        })
        
    */
    constructor(values: Object = {}){
        Object.assign(this,values);
    }
}
