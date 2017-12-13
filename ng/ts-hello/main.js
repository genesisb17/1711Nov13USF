function log(message) {
    console.log(message);
}
var message = "hellooooooooo world!";
log(message);
//tsc main.ts "Transpiles" our ts file to js
////////////////TYPESCRIPT VAR DECLARATIONS
var number = 1; // ES5 - supported by essentially all browsers 
var num = 2; // ES6
function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    console.log('Finally: ' + i);
}
doSomething();
// types
var count = 5; // behind the scenes says let count: number
//count = 'a'; //cannot be assigned to type var; typescript is strongly typed
//better to write code in TS so we get compilation errors 
var x; // let x: any
//if we don't know the type of var ahead of time, we use type annoyations
var a;
var b;
var c;
var d;
var e;
e = [1, true, 'a', false];
//can also define enums
var ColorRed = 0;
var ColorGreen = 1;
var ColorBlue = 2;
//enum Color {Red, Green, Blue}; // values auto get values of 0,1,2... ; but we should explicitly set them
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
;
var backgroundColor = Color.Red;
