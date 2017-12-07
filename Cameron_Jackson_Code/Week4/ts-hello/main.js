/* COMMENT OUT LESSONS THAT YOU AREN'T TESTING */
// function log(message) {
//     console.log(message);
// }
// var message = 'Hello World';
// log(message);
// Lesson 2
// var number = 1;
// let count = 6;
// function doSomething() {
//     for (let i = 0; i < 5; i++) {
//         console.log(i);
//     }
//     console.log(`Finally: ${i}`);
// }
// doSomething();
// Lesson 3
// let count = 5; // if using vs code hover over the variable for info on type
// count = 'a';
// let a; // hover for type info
// strict typing
// let a: number;
// let b: boolean;
// let c: string;
// let d: any; 
// let e: number[] = [1, 2, 3]; // initialization optional
// let f: any[] = [1, true, 'a', false];
// enumerations
// * javascript would use constants
// const ColorRed = 0;
// const ColorGreen = 1;
// const ColorBlue = 2;
// * typescript enum
// behaves like enumerated type with type indexes beginning at 0
// recommended to explicitly define the type values
// enum Color {Red = 0, Green = 1, Blue = 2};
// let backgroundColor = Color.Red; 
// Lesson 4 (Type assertions)
// let message;
// message = 'abc';
// let endsWithC = (<string>message).endsWith('c');
// let alternativeWay = (message as string).endsWith('c');
// Arrow functions
var log = function (message) {
    console.log(message);
};
var doLog = function (message) {
    console.log(message);
};
// curly braces can be left off for one line functions
// paren around the paramenters is optional if only one paramenter
// at least include the parenthesis for readability
// let doLog = message => console.log(message);
// In-line annotation examples
// If you have a lot of parameters you can group parameters by objects
// let drawPoint = (point: { x: number, y: number}) => {
//     // ... drawing algorithm isn't important
// }
// drawPoint({
//     x: 1,
//     y: 2
// })
// Instead of 
// let drawPoint = (x,y,a,b,c,d,e,f) => {
// }
// but can also use interface
// interface Point {
//     x: number,
//     y: number
// }
// let drawPoint = (point: Point) => {
//     // ...
// }
// let getDistance = (pointA: Point, pointB: Point) => {
//     // ...
// }
// call the interface
// drawPoint({
//     x: 1,
//     y: 2
// })
// to make declarations concise
// Use classes to group related interface objects
// class Point {
//     x: number;
//     y: number;
//     draw() {
//         console.log('X: ' + this.x + ', Y: ' + this.y);
//     }
// }
// declare variable of this class, must be initialized
// let point = new Point();
// point.x = 1;
// point.y = 2;
// point.draw();
// using constructor
// class Point {
//     x: number;
//     y: number;
//     // question mark makes parameter optional
//     // once used, all parameters to the right should also be optional
//     constructor(x?: number, y?: number) {
//         this.x = x;
//         this.y = y;
//     }
//     draw() {
//         console.log('X: ' + this.x + ', Y: ' + this.y);
//     }
// }
// let point = new Point(3,2);
// point.draw();
// access modifiers
var Point = /** @class */ (function () {
    // question mark makes parameter optional
    // once used, all parameters to the right should also be optional
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.draw = function () {
        console.log('X: ' + this.x + ', Y: ' + this.y);
    };
    return Point;
}());
var point = new Point(3, 2);
point.draw();
