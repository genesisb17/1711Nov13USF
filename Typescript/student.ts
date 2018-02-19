class Student implements Person {
    // no modifier means this value is public
    fullName: string;

    // Constructor can take arguments with access modifiers.
    // These arguments then act as class variables with those modifiers.
    constructor(public firstName: string, protected middleInitial: string, public lastName: string) {
        this.fullName = firstName+' '+middleInitial+' '+lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;
}

let stu = new Student('Stu', 'E', 'Pickles');

function printStudent(person: Person) {
    console.log(person);
}

window.onload=function() {
    printStudent(stu);
}