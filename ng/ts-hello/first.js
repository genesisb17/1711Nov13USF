function greeting(person) {
    return "Hello " + person.firstName;
}
var user = { firstName: "Gen", lastName: "Bo" };
document.body.innerHTML = greeting(user);
