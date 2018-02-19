import { Feline, Lion } from './cat';

function main (): string {
    console.log("Hello");
    return "hello";
}
main();
// We define our interface here
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


// This is how we use the interface
rl.question("Input your age.", (answer) => {
    console.log(`Wow, you are old at ${answer}`);
})

var feline = new Feline("mew", "black");
console.log(feline);