export class User {
    id: number;
    role: number;
    username: string;
    password: string;
    email: string;
    fname: string;
    lname: string;

    constructor() {
        this.id = this.role = 0;
        this.username = this.password = this.email = this.fname = this.lname = "";
    }
}