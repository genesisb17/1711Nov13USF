export class Todo {
    // our todo class has three instance properties
    id: number;
    title: string = '';
    complete: boolean = false;

    /*
      Adding constructer loging that allows us to specify property
      values during instantiation so that we can easily create new todo instances

        let todo = new Todo({
            title: 'Finish Project 1',
        });
        
     */
    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
