export class Todo {
    //class has 3 properties
    id: number;
    title: string = "";
    complete: boolean = false;

    /*
    we are adding constructor logic that let us specify propety 
    values during instantiation so that we can easily create new todo
    instances example:
let todo = new Todo({
    title:''finish groject, complete:false
}); 

    */
    constructor(values: Object={}){
        Object.assign(this,values);
    }

    
}
