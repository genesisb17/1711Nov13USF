"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
// We define our interface here
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// Set up
var users = [
    new user_1.User('Richard', 'pass'),
    new user_1.User('Nickolas', 'pass2'),
    new user_1.User('Carolyn', 'pass3')
];
users[0].accounts = [
    new account_1.Account(500, 'Savings'),
    new account_1.Account(400, 'Checking')
];
users[1].accounts = [
    new account_1.Account(250, 'Savings'),
    new account_1.Account(300, 'Checking')
];
users[2].accounts = [
    new account_1.Account(700, 'Savings'),
    new account_1.Account(600, 'Checking')
];
var username;
var password;
var loggedUser;
var account;
getUsername();
function getUsername() {
    rl.question("Input your username: ('q' to quit) ", function (answer) {
        if (answer === 'q') {
            rl.close();
        }
        else {
            username = answer;
            getPassword();
        }
    });
}
function getPassword() {
    rl.question("Input your password: ", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.find(function (user) { return user.login(username, password); });
    if (loggedUser) {
        options();
    }
    else {
        getUsername();
    }
}
function options() {
    loggedUser.accounts.forEach(function (acc) {
        console.log(acc.type);
    });
    rl.question("Choose an account: ('q' to quit) ", function (answer) {
        if (answer === 'q') {
            rl.close();
        }
        else {
            account = loggedUser.accounts.find(function (acc) { return acc.type === answer; });
            if (account) {
                operations();
            }
            else {
                options();
            }
        }
    });
    function operations() {
        console.log("Current Balance: " + account.balance);
        rl.question("'w' for withdraw, 'd' for deposit: ", function (answer) {
            if (answer === 'w') {
                rl.question("Amount: ", function (answer) {
                    account.withdraw(answer);
                    console.log("Current Balance: " + account.balance);
                    console.log("Logging out");
                    getUsername();
                });
            }
            else {
                if (answer === 'd') {
                    rl.question("Amount: ", function (answer) {
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
