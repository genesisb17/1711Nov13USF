"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
var readline = require('readline');
var r1 = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var users = [
    new user_1.User('C', 'pass'),
    new user_1.User('W', 'pass'),
    new user_1.User('G', 'pass')
];
users[0].accounts = [
    new account_1.Account(100, 'Savings'),
    new account_1.Account(500, 'Checking')
];
users[1].accounts = [
    new account_1.Account(100, 'Savings'),
    new account_1.Account(500, 'Checking')
];
users[2].accounts = [
    new account_1.Account(100, 'Savings'),
    new account_1.Account(500, 'Checking')
];
var username;
var password;
var loggedUser;
var account;
getUsername();
function getUsername() {
    r1.question("Input your username: ('q' to Quit)", function (answer) {
        if (answer === 'q')
            r1.close();
        else {
            username = answer;
            getPassword();
        }
    });
}
function getPassword() {
    r1.question("Input your apssword", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.filter(function (user) { return user.login(username, password); })[0];
    if (loggedUser) {
    }
    else {
        getUsername();
    }
}
