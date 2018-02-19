"use strict";
exports.__esModule = true;
var cat_1 = require("./cat");
function main() {
    console.log("Hello");
    return "hello";
}
main();
// We define our interface here
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// This is how we use the interface
rl.question("Input your age.", function (answer) {
    console.log("Wow, you are old at " + answer);
});
var feline = new cat_1.Feline("mew", "black");
console.log(feline);
