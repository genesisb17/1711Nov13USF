interface Person{
    firstName: string;
    lastName: string;
}

class Student{
    fullName: string;
    constructor(public firstName: string, public middleInitial: string, public lastName: string){
        this.fullName = `${firstName} ${middleInitial}. ${lastName}`;
    }
}

function greeting(person: Person){
    return `Hello ${person.firstName}`;
}

let user = new Student("Gen", "A", "Bonds");

document.body.innerHTML = greeting(user);