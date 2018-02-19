import { User } from "./user";
import { Account } from "./account";

const readline = require('readline');

const r1 = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let users = [
    new User('C', 'pass'),
    new User('W', 'pass'), 
    new User('G', 'pass')
];

users[0].accounts = [
    new Account(100, 'Savings'),
    new Account(500, 'Checking')
];

users[1].accounts = [
    new Account(100, 'Savings'),
    new Account(500, 'Checking')
];

users[2].accounts = [
    new Account(100, 'Savings'),
    new Account(500, 'Checking')
];

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

getUsername();

function getUsername(){
    r1.question("Input your username: ('q' to Quit)", (answer: string) => {
    if(answer === 'q') r1.close();
    else {
        username = answer;
        getPassword();
    }
    });
}

function getPassword(){
    r1.question("Input your apssword", (answer: string) =>{
        password = answer;
        login();
    })
}

function login(){
    loggedUser = users.filter((user: User) => user.login(username, password))[0];
    if(loggedUser){

    }
    else{
        getUsername();
    }
}