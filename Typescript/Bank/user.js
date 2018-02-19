"use strict";
exports.__esModule = true;
var User = /** @class */ (function () {
    function User(user, pass) {
        this.username = user;
        this.password = pass;
    }
    User.prototype.login = function (user, pass) {
        return this.username === user && this.password === pass;
    };
    User.prototype.getAccount = function (type) {
        return this.accounts.find(function (account) { return account.type === type; });
    };
    return User;
}());
exports.User = User;
