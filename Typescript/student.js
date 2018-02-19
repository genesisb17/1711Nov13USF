var Student = /** @class */ (function () {
    // Constructor can take arguments with access modifiers.
    // These arguments then act as class variables with those modifiers.
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.fullName = firstName + ' ' + middleInitial + ' ' + lastName;
    }
    return Student;
}());
var stu = new Student('Stu', 'E', 'Pickles');
function printStudent(person) {
    console.log(person);
}
window.onload = function () {
    printStudent(stu);
};
