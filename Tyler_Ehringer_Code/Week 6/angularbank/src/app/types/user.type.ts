export class User{
    
    id: number;
    username: string;
    password: string;
    fname: string;
    lname: string;
    balance: number;

    constructor(values: {} = {}) {
        Object.assign(this, values);
    }
}