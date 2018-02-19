import { User } from './user';
import { Account } from './account';

// We define our interface here
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Set up
var users = [
    new User('Richard', 'pass'),
    new User('Nickolas', 'pass2'),
    new User('Carolyn', 'pass3')
];

users[0].accounts = [
    new Account(500, 'Savings'),
    new Account(400, 'Checking')
]

users[1].accounts = [
    new Account(250, 'Savings'),
    new Account(300, 'Checking')
]
users[2].accounts = [
    new Account(700, 'Savings'),
    new Account(600, 'Checking')
]

var username;
var password;

var loggedUser;
var account;

getUsername();

function getUsername() {
    rl.question("Input your username: ('q' to quit) ", (answer) => {
        if(answer === 'q') {
            rl.close();
        } else {
            username = answer;
            getPassword();
        }
    });
}

function getPassword() {
    rl.question("Input your password: ", (answer) => {
        password = answer;
        login();
    });
}

function login() {
    loggedUser = users.find((user) => user.login(username, password));
    if (loggedUser) {
        options();
    } else {
        getUsername();
    }
}

function options() {
    loggedUser.accounts.forEach((acc) => {
        console.log(acc.type);
    });
    rl.question("Choose an account: ('q' to quit) ", (answer) => {
        if (answer === 'q') {
            rl.close();
        } else {
            account = loggedUser.accounts.find((acc) => acc.type === answer);
            if (account) {
                operations();
            } else {
                options();
            }
        }
    });
    function operations() {
        console.log("Current Balance: " + account.balance);
        rl.question("'w' for withdraw, 'd' for deposit: ", (answer) => {
            if (answer === 'w') {
                rl.question("Amount: ", (answer) => {
                    account.withdraw(answer);
                    console.log("Current Balance: " + account.balance);
                    console.log("Logging out");
                    getUsername();
                });
            } else {
                if (answer === 'd') {
                    rl.question("Amount: ", (answer) => {
                        account.deposit(answer);
                        console.log("Current Balance: " + account.balance);
                        console.log("Logging out");
                        getUsername();
                    });
                }
                else {
                    operations();
                }
            }
        });
    }
}